package com.lambdaschool.wanderlust.services;

import com.lambdaschool.wanderlust.exceptions.ResourceNotFoundException;
import com.lambdaschool.wanderlust.models.Profile;
import com.lambdaschool.wanderlust.models.User;
import com.lambdaschool.wanderlust.repository.ProfileRepository;
import com.lambdaschool.wanderlust.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

/**
 * Created by Andrew Brudnak ATBAAS on 7/31/2019.
 */

@Service(value = "profileService")
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileRepository profilerepos;

    @Autowired
    private UserRepository userrepos;

    @Override
    public ArrayList<Profile> findAll(Pageable pageable) {
        ArrayList<Profile> list = new ArrayList<>();
        profilerepos.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public ArrayList<Profile> findAll() {
        ArrayList<Profile> list = new ArrayList<>();
        profilerepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Profile findProfileById(long userid) throws ResourceNotFoundException {
        User u = userrepos.findById(userid).orElseThrow(() -> new ResourceNotFoundException(Long.toString(userid)));
        long profileid = u.getProfile().getProfileid();

        return profilerepos.findById(profileid).orElseThrow(() -> new ResourceNotFoundException(Long.toString(profileid)));
    }

    @Transactional
    @Override
    public Profile save(Profile profile, long userid) {
        User u = userrepos.findById(userid).orElseThrow(() -> new ResourceNotFoundException(Long.toString(userid)));

        Profile newProfile = new Profile();
        newProfile.setFirstname(profile.getFirstname());
        newProfile.setLastname(profile.getLastname());
        newProfile.setEmail(profile.getEmail());
        newProfile.setTelephone(profile.getTelephone());
        newProfile.setAbout(profile.getAbout());

        newProfile.setUser(u);

        u.setProfile(newProfile);
        userrepos.save(u);

        return profilerepos.save(newProfile);
    }

    @Override
    public Profile update(Profile profile, long userid) {
        User u = userrepos.findById(userid).orElseThrow(() -> new EntityNotFoundException(Long.toString(userid)));
        long profileid = u.getProfile().getProfileid();

        Profile currentProfile = profilerepos.findById(profileid).orElseThrow(() -> new EntityNotFoundException(Long.toString(profileid)));

        if (profile.getFirstname() != null) {
            currentProfile.setFirstname(profile.getFirstname());
        }
        if (profile.getLastname() != null) {
            currentProfile.setLastname(profile.getLastname());
        }
        if (profile.getEmail() != null) {
            currentProfile.setEmail(profile.getEmail());
        }
        if (profile.getTelephone() != null) {
            currentProfile.setTelephone(profile.getTelephone());
        }
        if (profile.getAbout() != null) {
            currentProfile.setAbout(profile.getAbout());
        }



        return profilerepos.save(currentProfile);
    }
}
