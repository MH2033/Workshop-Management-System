package com.project.workshopmanagment.repository.wokrshop;

import com.project.workshopmanagment.entity.ContactPoint;
import com.project.workshopmanagment.entity.workshop.OfferedWorkshop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;

public interface OfferedWorkshopRepository extends CrudRepository<OfferedWorkshop, Long> {

    @PostAuthorize("hasAnyAuthority('ROLE_SYSADMIN', 'ROLE_ORGANIZER')")
    <S extends OfferedWorkshop> S save(S s);

}
