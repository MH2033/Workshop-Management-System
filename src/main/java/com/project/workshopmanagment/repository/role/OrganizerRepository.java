package com.project.workshopmanagment.repository.role;

import com.project.workshopmanagment.entity.role.Organizer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;

public interface OrganizerRepository extends CrudRepository<Organizer, Long> {
    @PostAuthorize("hasAuthority('ROLE_SYSADMIN')")
    Iterable<Organizer> findAll();
}
