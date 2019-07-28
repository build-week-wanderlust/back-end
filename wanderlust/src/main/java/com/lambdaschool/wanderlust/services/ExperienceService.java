package com.lambdaschool.wanderlust.services;

import com.lambdaschool.wanderlust.models.Experience;

import java.util.List;

public interface ExperienceService
{
    List<Experience> findAll();

    Experience updateExperience(Experience experience, long id);

    Experience findExperienceById(long id);

    List<Experience> findByUserName(String username);

    void delete(long id);

    Experience save(Experience experience);
}
