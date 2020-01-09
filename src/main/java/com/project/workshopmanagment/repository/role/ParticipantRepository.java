package com.project.workshopmanagment.repository.role;

import com.project.workshopmanagment.entity.role.Participant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {
    @PostAuthorize("hasAuthority('ROLE_SYSADMIN')")
    Iterable<Participant> findAll();
}
