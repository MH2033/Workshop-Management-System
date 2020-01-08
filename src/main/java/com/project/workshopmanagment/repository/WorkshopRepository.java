package com.project.workshopmanagment.repository;

import com.project.workshopmanagment.entity.Role;
import com.project.workshopmanagment.entity.Workshop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;

public interface WorkshopRepository extends CrudRepository<Workshop, Long> {
}
