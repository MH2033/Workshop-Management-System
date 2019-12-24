package com.project.workshopmanagment.dao;

import com.project.workshopmanagment.entity.ContactPoint;
import com.project.workshopmanagment.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactPointRepository extends JpaRepository<ContactPoint, Integer> {
}
