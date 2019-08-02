package com.lambdaschool.wanderlust.controllers;

import com.lambdaschool.wanderlust.models.ErrorDetail;
import com.lambdaschool.wanderlust.models.Profile;
import com.lambdaschool.wanderlust.models.User;
import com.lambdaschool.wanderlust.services.ProfileService;
import com.lambdaschool.wanderlust.services.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Created by Andrew Brudnak ATBAAS on 7/31/2019.
 */

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Returns all Profiles",
            response = Profile.class,
            responseContainer = "List")
    @GetMapping(value = "/allprofiles",
            produces = {"application/json"})
    public ResponseEntity<?> getListOfAllProfiles() {
        ArrayList<Profile> myProfile = profileService.findAll();
        return new ResponseEntity<>(myProfile, HttpStatus.OK);
    }


    @ApiOperation(value = "Retrieves a Profile associated with the userid.",
            response = Profile.class)
    @ApiResponses(value = {@ApiResponse(code = 201,
            message = "Profile Found",
            response = Profile.class), @ApiResponse(code = 404,
            message = "Profile Not Found",
            response = ErrorDetail.class)})
    @GetMapping(value = "/profile/{profileid}",
            produces = {"application/json"})
    public ResponseEntity<?> getProfileByUserId(
            @PathVariable
                    long userid) {
        Profile p = profileService.findProfileById(userid);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @ApiOperation(value = "Creates a new Profile.",
            notes = "",
            response = void.class)
    @ApiResponses(value = {@ApiResponse(code = 201,
            message = "Profile Created Successfully",
            response = void.class), @ApiResponse(code = 500,
            message = "Error Creating Profile",
            response = ErrorDetail.class)})
    @PostMapping(value = "/profile",
            produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity<?> createProfile(@Valid Authentication authentication,
                                           @RequestBody
                                                   Profile profile) throws URISyntaxException {
        User u = userService.findUserByName(authentication.getName());
        long userid = u.getUserid();

        profile = profileService.save(profile, userid);
        u.setProfile(profile);
        userService.save(u);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Updates a current Profile by userid",
            response = void.class)
    @ApiResponses(value = {@ApiResponse(code = 400,
            message = "Need Valid Profile Object",
            response = ErrorDetail.class), @ApiResponse(code = 404,
            message = "Profile Not Found",
            response = ErrorDetail.class)})
    @PutMapping(value = "/profile/{userid}",
            produces = {"application/json"})
    public ResponseEntity<?> updateProfileByUserId(@Valid
                                                   @RequestBody
                                                           Profile profile,
                                                   @PathVariable
                                                           long userid) {
        profileService.update(profile, userid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

