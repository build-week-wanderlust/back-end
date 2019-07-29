package com.lambdaschool.wanderlust.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "experiences")
public class Experience extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long experienceid;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(nullable = false)
    private String city;

    @Size(min = 2, max = 2, message = "State is the two character state abbreviation")
    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String triptype;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid",
                nullable = false)
    @JsonIgnoreProperties({"experiences", "hibernateLazyInitializer"})
    private User user;

    public Experience() {
    }

    public Experience(String title, String description, String city, @Size(min = 2,
            max = 2,
            message = "State is the two character state abbreviation") String state, double price, String triptype, User user) {
        this.title = title;
        this.description = description;
        this.city = city;
        this.state = state;
        this.price = price;
        this.triptype = triptype;
        this.user = user;
    }

    public long getExperienceid() {
        return experienceid;
    }

    public void setExperienceid(long experienceid) {
        this.experienceid = experienceid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTriptype() {
        return triptype;
    }

    public void setTriptype(String triptype) {
        this.triptype = triptype;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}