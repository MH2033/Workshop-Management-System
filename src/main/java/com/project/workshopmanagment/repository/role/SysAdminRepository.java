package com.project.workshopmanagment.repository.role;

import com.project.workshopmanagment.entity.role.SysAdmin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

public interface SysAdminRepository extends CrudRepository<SysAdmin, Long> {

    @PreAuthorize("hasAuthority('ROLE_SYSADMIN')")
    <S extends SysAdmin> S save(S s);

}
