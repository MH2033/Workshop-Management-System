package com.project.workshopmanagment.repository.role;

import com.project.workshopmanagment.entity.role.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

public interface RoleRepository extends CrudRepository<Role, Long> {
    @PreAuthorize(("hasAuthority('ROLE_SYSADMIN')"))
    Iterable<Role> findAll();
}
