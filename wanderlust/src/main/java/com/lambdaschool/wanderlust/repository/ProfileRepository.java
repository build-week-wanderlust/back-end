package com.lambdaschool.wanderlust.repository;

import com.lambdaschool.wanderlust.models.Profile;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Andrew Brudnak ATBAAS on 7/31/2019.
 */

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
