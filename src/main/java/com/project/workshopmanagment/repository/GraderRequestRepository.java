package com.project.workshopmanagment.repository;

import com.project.workshopmanagment.entity.GraderRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface GraderRequestRepository extends CrudRepository<GraderRequest, Long> {
}
