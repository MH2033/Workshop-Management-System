package com.project.workshopmanagment.repository;

import com.project.workshopmanagment.entity.Grader;
import com.project.workshopmanagment.entity.Role;
import com.project.workshopmanagment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface GraderRepository extends CrudRepository<Grader, Long> {
    @PostAuthorize("hasAuthority('ROLE_SYSADMIN')")
    Iterable<Grader> findAll();

    @PostAuthorize("hasAuthority('ROLE_SYSADMIN')")
    Optional<Grader> findById(@PathVariable Long id);
}
