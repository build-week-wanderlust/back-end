package com.lambdaschool.wanderlust;

import com.lambdaschool.wanderlust.models.Experience;
import com.lambdaschool.wanderlust.models.Role;
import com.lambdaschool.wanderlust.models.User;
import com.lambdaschool.wanderlust.models.UserRoles;
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
        User u2 = new User("andrew", "password", datas);
        u2.getExperiences().add(new Experience("Wine Tasting", "For wine enthusiasts, the Sonoma and Napa Valleys are often the pinnacle of the North American wine experience. However, for the uninitiated, choosing where and when to go can be a little daunting. This coach tour shuttles you in style to three famous wineries in northern California: Madonna Estate, Sebastiani Vineyards and Sutter Home. Stop for lunch in historic downtown Sonoma Square, where you'll find a bevy of dining options and boutique shops for exploration.", "San Francisco", "CA", 135.00, u2));
        u2.getExperiences().add(new Experience("Wine Country by Helicopter", "Fly by helicopter from the San Francisco Bay Area to Wine Country during this tour. Enjoy views of the city, the Golden Gate Bridge, Alcatraz and Wine Country's rolling vineyards before touching down at one of the area's most prestigious wineries. Enjoy a guided tour of the property, tapas and a wine tasting. With your small group limited to 6 people, learn about the winery's world-class varietals and all the love and labor that goes into making the perfect cabernet. When your 3-hour excursion is over, travel back to San Francisco by helicopter.", "San Francisco", "CA", 460.00, u2));
        userService.save(u2);

        // user
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u3 = new User("russell", "password", users);
        userService.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u4 = new User("ruby", "password", users);
        userService.save(u4);
    }
}