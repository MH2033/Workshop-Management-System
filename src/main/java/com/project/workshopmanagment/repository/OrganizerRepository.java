package com.project.workshopmanagment.repository;

import com.project.workshopmanagment.entity.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
}
