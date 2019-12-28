package com.project.workshopmanagment.repository;

import com.project.workshopmanagment.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
