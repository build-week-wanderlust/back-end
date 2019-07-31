package com.lambdaschool.wanderlust.controllers;

import com.lambdaschool.wanderlust.models.ErrorDetail;
import com.lambdaschool.wanderlust.models.Experience;
import com.lambdaschool.wanderlust.services.ExperienceService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/experiences")
public class ExperienceController {
    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);

    @Autowired
    ExperienceService experienceService;

    // http://localhost:2019/experiences/experiences

    // http://localhost:2019/experiences/experiences/?page=0&size=5
    // http://localhost:2019/experiences/experiences/?sort=state

    @ApiOperation(value = "Returns all Experiences with Paging Ability",
            responseContainer = "List")
    @ApiImplicitParams({@ApiImplicitParam(name = "page",
            dataType = "integer",
            paramType = "query",
            value = "Results page you want to retrieve (0..N)"), @ApiImplicitParam(name = "size",
            dataType = "integer",
            paramType = "query",
            value = "Number of records per page."), @ApiImplicitParam(name = "sort",
            allowMultiple = true,
            dataType = "string",
            paramType = "query",
            value = "Sorting criteria in the format: property(,asc|desc). " + "Default sort order is ascending. " + "Multiple sort criteria are supported.")})
    @GetMapping(value = "/experiences",
            produces = {"application/json"})
    public ResponseEntity<?> listAllExperiences(
            @PageableDefault(page = 0,
                    size = 5)
                    Pageable pageable, HttpServletRequest request) {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Experience> allExperiences = experienceService.findAll(pageable);
        return new ResponseEntity<>(allExperiences, HttpStatus.OK);
    }

    // get all experiences
    @ApiOperation(value = "Retrieves all experiences without paging and sorting enabled", responseContainer = "List")
    @GetMapping(value = "/allexperiences")
    public ResponseEntity<?> reallyListAllExperiences() {

        List<Experience> allExperiences = experienceService.findAll();
        return new ResponseEntity<>(allExperiences, HttpStatus.OK);
    }


    @ApiOperation(value = "Retrieves an experience associated with the experience ID",
            response = Experience.class)
    @ApiResponses(value = {@ApiResponse(code = 201,
            message = "Experience Found",
            response = Experience.class), @ApiResponse(code = 404,
            message = "Experience Not Found",
            response = ErrorDetail.class)})
    @GetMapping(value = "/experiences/{experienceId}",
            produces = {"application/json"})
    public ResponseEntity<?> getExperience(HttpServletRequest request,
                                           @ApiParam(value = "Experience ID", required = true, example = "1")
                                           @PathVariable
                                                   Long experienceId) {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        Experience e = experienceService.findExperienceById(experienceId);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }


    @ApiOperation(value = "Find Experiences by the Username", responseContainer = "List")
    @GetMapping(value = "/username/{userName}",
            produces = {"application/json"})
    public ResponseEntity<?> findExperienceByUserName(HttpServletRequest request,
                                                      @ApiParam(value = "Username", required = true, example = "Andrew")
                                                      @PathVariable
                                                              String userName) {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Experience> theExperiences = experienceService.findByUserName(userName);
        return new ResponseEntity<>(theExperiences, HttpStatus.OK);
    }


    @ApiOperation(value = "Creates a new Experience", notes = "The newly created experience ID will be sent in the location header", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Experience Created", response = void.class),
            @ApiResponse(code = 500, message = "Error Creating Experience", response = ErrorDetail.class)
    })
    @PostMapping(value = "/experience")
    public ResponseEntity<?> addNewExperience(HttpServletRequest request, @Valid
    // No swagger documentation for request body, conflict with Spring Framework
    @RequestBody
            Experience newExperience) throws URISyntaxException {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        newExperience = experienceService.save(newExperience);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newExperienceURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{experienceid}").buildAndExpand(newExperience.getExperienceid()).toUri();
        responseHeaders.setLocation(newExperienceURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update a current experience",
            response = Experience.class)
    @ApiResponses(value = {@ApiResponse(code = 201,
            message = "Successfully updated experience",
            response = void.class), @ApiResponse(code = 500,
            message = "Failed to update experience",
            response = ErrorDetail.class)})

    @PutMapping(value = "/data/experience/{id}")
    public ResponseEntity<?> updateExperience(
            @PathVariable
                    long id,
            @RequestBody
                    Experience experience) {
        experienceService.updateExperience(experience, id);
        return new ResponseEntity<>(experience, HttpStatus.OK);
    }


    @ApiOperation(value = "Delete experience by its ID")
    @DeleteMapping("/experience/{id}")
    public ResponseEntity<?> deleteExperienceById(HttpServletRequest request,
                                                  @ApiParam(value = "Experience ID", required = true, example = "1")
                                                  @PathVariable
                                                          long id) {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        experienceService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
