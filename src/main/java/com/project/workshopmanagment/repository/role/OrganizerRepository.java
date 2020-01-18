package com.project.workshopmanagment.repository.role;

import com.project.workshopmanagment.entity.role.Organizer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

public interface OrganizerRepository extends CrudRepository<Organizer, Long> {

    @PreAuthorize("hasAuthority('ROLE_SYSADMIN')")
    Iterable<Organizer> findAll();

    @PreAuthorize("hasAuthority('ROLE_SYSADMIN')")
    <S extends Organizer> S save(S s);


}
