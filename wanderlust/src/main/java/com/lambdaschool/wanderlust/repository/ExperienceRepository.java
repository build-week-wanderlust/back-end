package com.lambdaschool.wanderlust.repository;

import com.lambdaschool.wanderlust.models.Experience;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExperienceRepository extends PagingAndSortingRepository<Experience, Long> {

}
