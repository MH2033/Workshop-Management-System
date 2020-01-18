package com.project.workshopmanagment.repository;

import com.project.workshopmanagment.entity.ContactPoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

public interface ContactPointRepository extends CrudRepository<ContactPoint, Long> {
    @PreAuthorize("hasAuthority('ROLE_SYSADMIN')")
    Iterable<ContactPoint> findAll();
}
