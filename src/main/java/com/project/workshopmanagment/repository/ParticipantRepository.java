package com.project.workshopmanagment.repository;

import com.project.workshopmanagment.entity.Participant;
import com.project.workshopmanagment.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {
    @PostAuthorize("hasAuthority('ROLE_SYSADMIN')")
    Iterable<Participant> findAll();
}
