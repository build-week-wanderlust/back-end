package com.lambdaschool.wanderlust.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

/**
 * Created by Andrew Brudnak ATBAAS on 7/31/2019.
 */

@ApiModel(value = "Profile", description = "The Profile Entity")
@Entity
@Table(name = "profiles")
public class Profile extends Auditable {

    @ApiModelProperty(name = "profileid", value = "Primary Key for Profile", required = true, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long profileid;

    @ApiModelProperty(name = "firstname", value = "First Name of Profile", example = "Andrew")
    @Column
    private String firstname;

    @ApiModelProperty(name = "lastname", value = "Last Name of Profile", example = "Andrew")
    @Column
    private String lastname;

    @ApiModelProperty(name = "email", value = "User Email", example = "brudnak@icloud.com")
    @Email(message = "Email should be valid username@domain.toplevel - brudnak@icloud.com")
    @Column
    private String email;

    @ApiModelProperty(name = "telephone", value = "User Telephone", example ="555-555-5555")
    @Pattern(regexp="\\d{3}-\\d{3}-\\d{4}", message = "Telephone is only numbers 555-555-5555")
    @Column
    private String telephone;

    @ApiModelProperty(name = "about", value = "About the User", example = "Offering tours of Grand Canyon National Park")
    @Column(columnDefinition = "TEXT", nullable = false)
    private String about;

    @OneToOne(mappedBy = "profile")
    @JsonIgnoreProperties("profile")
    private User user;

    public Profile() {
    }

    public Profile(String firstname, String lastname, @Email(message = "Email should be valid username@domain.toplevel - brudnak@icloud.com") String email, @Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}",
            message = "Telephone is only numbers 555-555-5555") String telephone, String about, User user) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.telephone = telephone;
        this.about = about;
        this.user = user;
    }

    public long getProfileid() {
        return profileid;
    }

    public void setProfileid(long profileid) {
        this.profileid = profileid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
