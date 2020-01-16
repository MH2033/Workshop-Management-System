package com.project.workshopmanagment.repository.wokrshop;

import com.project.workshopmanagment.entity.workshop.Workshop;
import com.project.workshopmanagment.entity.workshop.WorkshopRelation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;

public interface WorkshopRelationRepository extends CrudRepository<WorkshopRelation, Long> {

    @PostAuthorize("hasAuthority('ROLE_SYSADMIN')")
    <S extends WorkshopRelation> S save(S s);

}
