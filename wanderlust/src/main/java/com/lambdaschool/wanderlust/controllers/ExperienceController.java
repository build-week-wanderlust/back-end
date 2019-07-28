package com.lambdaschool.wanderlust.controllers;

import com.lambdaschool.wanderlust.models.ErrorDetail;
import com.lambdaschool.wanderlust.models.Experience;
import com.lambdaschool.wanderlust.services.ExperienceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = "/experiences",
            produces = {"application/json"})
    public ResponseEntity<?> listAllExperiences(HttpServletRequest request) {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Experience> allExperiences = experienceService.findAll();
        return new ResponseEntity<>(allExperiences, HttpStatus.OK);
    }


    @GetMapping(value = "/experiences/{experienceId}",
            produces = {"application/json"})
    public ResponseEntity<?> getExperience(HttpServletRequest request,
                                           @PathVariable
                                                   Long experienceId) {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        Experience e = experienceService.findExperienceById(experienceId);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }


    @GetMapping(value = "/username/{userName}",
            produces = {"application/json"})
    public ResponseEntity<?> findExperienceByUserName(HttpServletRequest request,
                                                      @PathVariable
                                                              String userName) {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Experience> theExperiences = experienceService.findByUserName(userName);
        return new ResponseEntity<>(theExperiences, HttpStatus.OK);
    }


    @PostMapping(value = "/experience")
    public ResponseEntity<?> addNewExperience(HttpServletRequest request, @Valid
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


    @DeleteMapping("/experience/{id}")
    public ResponseEntity<?> deleteExperienceById(HttpServletRequest request,
                                             @PathVariable
                                                     long id) {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        experienceService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
