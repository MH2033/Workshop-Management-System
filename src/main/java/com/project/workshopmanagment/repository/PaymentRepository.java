package com.project.workshopmanagment.repository;

import com.project.workshopmanagment.entity.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
