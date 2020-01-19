package com.project.workshopmanagment.repository.wokrshop;

import com.project.workshopmanagment.entity.workshop.TakenWorkshop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;


public interface TakenWorkshopRepository extends CrudRepository<TakenWorkshop, Long> {

    @PostAuthorize("hasAuthority('ROLE_SYSADMIN')")
    Iterable<TakenWorkshop> findAll();
}
