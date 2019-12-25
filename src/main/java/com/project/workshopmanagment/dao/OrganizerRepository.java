package com.project.workshopmanagment.dao;

import com.project.workshopmanagment.entity.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizerRepository extends JpaRepository <Organizer, Integer> {
}
