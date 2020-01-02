package com.project.workshopmanagment.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Installment extends Payment {

    @OneToMany(mappedBy = "installment", cascade = CascadeType.ALL)
    List<Installments> installments;
}
