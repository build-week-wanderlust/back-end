package com.lambdaschool.wanderlust.services;

import com.lambdaschool.wanderlust.exceptions.ResourceNotFoundException;
import com.lambdaschool.wanderlust.models.Experience;
import com.lambdaschool.wanderlust.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "experienceService")
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    private ExperienceRepository experiencerepos;

    @Override
    public List<Experience> findAll(Pageable pageable) {
        List<Experience> list = new ArrayList<>();
        experiencerepos.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public List<Experience> findAll() {
        List<Experience> list = new ArrayList<>();
        experiencerepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public Experience updateExperience(Experience experience, long id) {
        Experience currentExperience = experiencerepos.findById(id).orElseThrow(EntityNotFoundException::new);
        if (experience.getTitle() != null) {
            currentExperience.setTitle(experience.getTitle());
        }
        if (experience.getDescription() != null) {
            currentExperience.setDescription(experience.getDescription());
        }
        if (experience.getCity() != null) {
            currentExperience.setCity(experience.getCity());
        }
        if (experience.getState() != null) {
            currentExperience.setState(experience.getState());
        }
        if (experience.getTriptype() != null) {
            currentExperience.setState(experience.getState());
        }
        if (experience.getPrice() > 0) {
            currentExperience.setPrice(experience.getPrice());
        }

        experiencerepos.save(currentExperience);
        return currentExperience;
    }

    @Override
    public Experience findExperienceById(long id) {
        return experiencerepos.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
    }

    @Override
    public void delete(long id) {
        if (experiencerepos.findById(id).isPresent()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (experiencerepos.findById(id).get().getUser().getUsername().equalsIgnoreCase(authentication.getName())) {
                experiencerepos.deleteById(id);
            } else {
                throw new ResourceNotFoundException(id + " " + authentication.getName());
            }
        } else {
            throw new ResourceNotFoundException(Long.toString(id));
        }
    }

    @Transactional
    @Override
    public Experience save(Experience experience) {
        return experiencerepos.save(experience);
    }

    @Override
    public List<Experience> findByUserName(String username) {
        List<Experience> list = new ArrayList<>();
        experiencerepos.findAll().iterator().forEachRemaining(list::add);

        list.removeIf(e -> !e.getUser().getUsername().equalsIgnoreCase(username));
        return list;
    }
}
