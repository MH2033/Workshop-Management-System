package com.project.workshopmanagment.entity;

import com.project.workshopmanagment.entity.enums.PaymentStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Installments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date paymentDate;

    private int price;

    private PaymentStatus paymentStatus;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "installment_id")
    private Installment installment;

    public Installments() {
    }

    public Installments(Date paymentDate, int price, PaymentStatus paymentStatus, Installment installment) {
        this.paymentDate = paymentDate;
        this.price = price;
        this.paymentStatus = paymentStatus;
        this.installment = installment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Installment getInstallment() {
        return installment;
    }

    public void setInstallment(Installment installment) {
        this.installment = installment;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
