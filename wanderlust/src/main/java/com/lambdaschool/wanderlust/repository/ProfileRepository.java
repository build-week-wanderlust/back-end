package com.lambdaschool.wanderlust.repository;

import com.lambdaschool.wanderlust.models.Profile;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Andrew Brudnak ATBAAS on 7/31/2019.
 */

public interface ProfileRepository extends PagingAndSortingRepository<Profile, Long> {
}
