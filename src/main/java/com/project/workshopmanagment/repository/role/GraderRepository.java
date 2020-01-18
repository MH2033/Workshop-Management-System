package com.project.workshopmanagment.repository.role;

import com.project.workshopmanagment.entity.role.Grader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface GraderRepository extends CrudRepository<Grader, Long> {
    @PreAuthorize("hasAuthority('ROLE_SYSADMIN')")
    Iterable<Grader> findAll();

    //@PostAuthorize("hasAuthority('ROLE_SYSADMIN')")
    //Optional<Grader> findById(@PathVariable Long id);
}
