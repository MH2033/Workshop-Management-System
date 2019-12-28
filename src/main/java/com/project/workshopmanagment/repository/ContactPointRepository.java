package com.project.workshopmanagment.repository;

import com.project.workshopmanagment.entity.ContactPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ContactPointRepository extends JpaRepository<ContactPoint, Long> {
}
