package com.project.workshopmanagment.repository;

import com.project.workshopmanagment.entity.Grader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface GraderRepository extends CrudRepository<Grader, Long> {
}
