package com.project.workshopmanagment.repository.role;

import com.project.workshopmanagment.entity.role.FinancialManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

public interface FinancialManagerRepository extends CrudRepository<FinancialManager, Long> {

    @PreAuthorize("hasAuthority('ROLE_SYSADMIN')")
    <S extends FinancialManager> S save(S s);

    @PreAuthorize("hasAuthority('ROLE_SYSADMIN')")
    Iterable<FinancialManager> findAll();
}
