package com.project.workshopmanagment.repository.payment;

import com.project.workshopmanagment.entity.payment.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
