package com.project.workshopmanagment.dao;

import com.project.workshopmanagment.entity.Grader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraderRepository extends JpaRepository <Grader, Integer> {
}
