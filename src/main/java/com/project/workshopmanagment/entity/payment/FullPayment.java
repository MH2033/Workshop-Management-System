package com.project.workshopmanagment.entity.payment;

import com.project.workshopmanagment.entity.enums.PaymentStatus;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class FullPayment extends Payment {

    private Date paymentDate;

    private PaymentStatus paymentStatus;

    public FullPayment() {
    }

    public FullPayment(Date paymentDate, PaymentStatus paymentStatus) {
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
