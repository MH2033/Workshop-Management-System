package com.project.workshopmanagment.repository.wokrshop;

import com.project.workshopmanagment.entity.ContactPoint;
import com.project.workshopmanagment.entity.workshop.OfferedWorkshop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;

public interface OfferedWorkshopRepository extends CrudRepository<OfferedWorkshop, Long> {

    @PostAuthorize("hasAuthority('ROLE_SYSADMIN')")
    <S extends OfferedWorkshop> S save(S s);

}
