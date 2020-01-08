package com.project.workshopmanagment.repository;

import com.project.workshopmanagment.entity.Role;
import com.project.workshopmanagment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;

public interface RoleRepository extends CrudRepository<Role, Long> {
    @PostAuthorize("hasAuthority('ROLE_SYSADMIN')")
    Iterable<Role> findAll();
}
