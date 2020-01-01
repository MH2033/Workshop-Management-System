package com.project.workshopmanagment.repository;

import com.project.workshopmanagment.entity.Workshop;
import org.springframework.data.repository.CrudRepository;

public interface WorkshopRepository extends CrudRepository<Workshop, Long> {
}
