package com.project.workshopmanagment.repository;

import com.project.workshopmanagment.entity.ContactPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactPointRepository extends JpaRepository<ContactPoint, Integer> {
}
