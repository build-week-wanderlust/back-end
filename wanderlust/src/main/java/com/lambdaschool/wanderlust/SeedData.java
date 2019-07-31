package com.lambdaschool.wanderlust;

import com.lambdaschool.wanderlust.models.*;
import com.lambdaschool.wanderlust.services.ProfileService;
import com.lambdaschool.wanderlust.services.RoleService;
import com.lambdaschool.wanderlust.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner {
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Autowired
    ProfileService profileService;


    @Override
    public void run(String[] args) throws Exception {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        roleService.save(r1);
        roleService.save(r2);
        roleService.save(r3);

        // admin, data, user
        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));
        admins.add(new UserRoles(new User(), r3));
        User u1 = new User("admin", "password", admins);
        userService.save(u1);

        // data, user
        ArrayList<UserRoles> datas = new ArrayList<>();
        datas.add(new UserRoles(new User(), r3));
        datas.add(new UserRoles(new User(), r2));
        User u2 = new User("AndrewB", "password", datas);
        u2.getExperiences().add(new Experience("Wine Tasting", "For wine enthusiasts, the Sonoma and Napa Valleys are often the pinnacle of the North American wine experience. However, for the uninitiated, choosing where and when to go can be a little daunting. This coach tour shuttles you in style to three famous wineries in northern California: Madonna Estate, Sebastiani Vineyards and Sutter Home. Stop for lunch in historic downtown Sonoma Square, where you'll find a bevy of dining options and boutique shops for exploration.", "San Francisco", "CA", 135.00, "Professional", u2));
        u2.getExperiences().add(new Experience("Wine Country by Helicopter", "Fly by helicopter from the San Francisco Bay Area to Wine Country during this tour. Enjoy views of the city, the Golden Gate Bridge, Alcatraz and Wine Country's rolling vineyards before touching down at one of the area's most prestigious wineries. Enjoy a guided tour of the property, tapas and a wine tasting. With your small group limited to 6 people, learn about the winery's world-class varietals and all the love and labor that goes into making the perfect cabernet. When your 3-hour excursion is over, travel back to San Francisco by helicopter.", "San Francisco", "CA", 460, "Private", u2));
        userService.save(u2);

        // user
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u3 = new User("RussellF", "password", users);
        u3.getExperiences().add(new Experience("Florida Air Boat Ride", "Our experienced captains have a knack for being able to spot alligators, eagles and other wildlife that build their homes in the waterways near Wild Florida. Each time you head out onto the water, you’ll see and experience something different.", "Kenansville", "FL", 59.00, "Professional", u3));
        u3.getExperiences().add(new Experience("Gator Encounter", "Go behind-the-scenes of our Gator Feeding Show with one of our animal educators to feed dozens of huge, hungry gators ready for their next meal. While in the crows nest, play one of our alligators’ favorite games… jumping for chicken! ", "Kenansville", "FL", 21.00, "Professional", u3));

        userService.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u4 = new User("RubyB", "password", users);
        u4.getExperiences().add(new Experience("Alaska Seaplane Tour", "Departing from Ketchikan in our beautiful seaplane, our tour will take us through the Misty Fjords National Monument and north to the prehistoric land of the Alaska Glacier.", "Ketchikan", "AK", 550.00, "Professional", u4));
        u4.getExperiences().add(new Experience("Ketchikan Shore Excursion: Zodiac Boat Wilderness Adventure", "Leave your cruise ship behind for a few hours and steer a Zodiac boat in the waters of the Alaskan wilderness. This small-group guided shore excursion from Ketchikan is limited to just four people, and everyone takes a turn at the wheel. Cruise through rain-forest islands, into remote bays and inlets, and spot wildlife including eagles, seals, whales and bears. Enjoy a beachside snack and a boatman certificate to take home as a souvenir. Round-trip port transport is included.", "Ketchikan", "AK", 179.00, "Professional", u4));
        userService.save(u4);




        Profile p1 = new Profile("Andrew", "Brudnak", "brudnak@icloud.com", "505-474-7549", "Offering Wine Inspired Experiences", u2);
        u2.setProfile(p1);
        profileService.save(p1, 5);

        Profile p2 = new Profile("Russell", "Freckingham", "rufreckingham@gmail.com", "898-804-9302", "Air boat tours are the best way to see Florida's exotic wild life!", u3);
        u3.setProfile(p2);
        profileService.save(p2, 8);

        Profile p3 = new Profile("Ruby", "Bernhardi", "rbernhardir92@gmail.com", "969-317-4943", "Experiences in Alaska, the last frontier", u4);
        u4.setProfile(p3);
        profileService.save(p3, 11);
    }
}