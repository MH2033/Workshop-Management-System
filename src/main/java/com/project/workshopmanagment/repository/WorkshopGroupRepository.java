package com.project.workshopmanagment.repository;

import com.project.workshopmanagment.entity.WorkshopGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface WorkshopGroupRepository extends CrudRepository<WorkshopGroup, Long> {
}
