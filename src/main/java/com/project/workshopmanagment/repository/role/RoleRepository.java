package com.project.workshopmanagment.repository.role;

import com.project.workshopmanagment.entity.role.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;

public interface RoleRepository extends CrudRepository<Role, Long> {
    @PostAuthorize("hasAuthority('ROLE_SYSADMIN')")
    Iterable<Role> findAll();
}
