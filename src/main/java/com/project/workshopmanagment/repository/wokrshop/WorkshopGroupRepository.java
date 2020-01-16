package com.project.workshopmanagment.repository.wokrshop;

import com.project.workshopmanagment.entity.workshop.Workshop;
import com.project.workshopmanagment.entity.workshop.WorkshopGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;

public interface WorkshopGroupRepository extends CrudRepository<WorkshopGroup, Long> {

    @PostAuthorize("hasAnyAuthority('ROLE_SYSADMIN', 'ROLE_ORGANIZER')")
    <S extends WorkshopGroup> S save(S s);

    @PostAuthorize("hasAuthority('ROLE_SYSADMIN')")
    Iterable<WorkshopGroup> findAll();
}
