package com.project.workshopmanagment.repository.payment;

import com.project.workshopmanagment.entity.payment.FullPayment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

public interface FullPaymentRepository extends CrudRepository<FullPayment, Long> {

    @PreAuthorize("hasAnyAuthority('ROLE_FINANCIALMANAGER', 'ROLE_SYSADMIN')")
    <S extends FullPayment> S save(S s);

}
