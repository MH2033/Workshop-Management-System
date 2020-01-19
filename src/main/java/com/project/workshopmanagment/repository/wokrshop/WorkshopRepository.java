package com.project.workshopmanagment.repository.wokrshop;

import com.project.workshopmanagment.entity.workshop.OfferedWorkshop;
import com.project.workshopmanagment.entity.workshop.Workshop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;

public interface WorkshopRepository extends CrudRepository<Workshop, Long> {

    @PostAuthorize("hasAuthority('ROLE_SYSADMIN')")
    <S extends Workshop> S save(S s);
    @PostAuthorize("hasAuthority('ROLE_SYSADMIN')")
    void delete(Workshop workshop);
    @PostAuthorize("hasAuthority('ROLE_SYSADMIN')")
    void deleteAll();
    @PostAuthorize("hasAuthority('ROLE_SYSADMIN')")
    void deleteById(Long aLong);
    @PostAuthorize("hasAuthority('ROLE_SYSADMIN')")
    void deleteAll(Iterable<? extends Workshop> iterable);

}
