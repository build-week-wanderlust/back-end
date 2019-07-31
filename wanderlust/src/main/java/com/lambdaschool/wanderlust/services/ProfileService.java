package com.lambdaschool.wanderlust.services;

import com.lambdaschool.wanderlust.models.Profile;
import org.springframework.data.domain.Pageable;


import java.util.ArrayList;

/**
 * Created by Andrew Brudnak ATBAAS on 7/31/2019.
 */
public interface ProfileService {

    ArrayList<Profile> findAll(Pageable pageable);

    ArrayList<Profile> findAll();

    Profile findProfileById(long userid);

    Profile save(Profile profile, long userid);

    Profile update(Profile profile, long userid);
}
