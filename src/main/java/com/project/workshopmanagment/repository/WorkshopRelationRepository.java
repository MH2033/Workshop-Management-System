package com.project.workshopmanagment.repository;

import com.project.workshopmanagment.entity.WorkshopRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface WorkshopRelationRepository extends CrudRepository<WorkshopRelation, Long> {
}
