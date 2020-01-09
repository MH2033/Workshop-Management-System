package com.project.workshopmanagment.repository.payment;

import com.project.workshopmanagment.entity.payment.Installment;
import org.springframework.data.repository.CrudRepository;

public interface InstallmentRepository extends CrudRepository<Installment, Long> {
}
