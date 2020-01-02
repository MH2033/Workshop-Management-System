package com.project.workshopmanagment.entity;

import javax.persistence.*;

@Inheritance
@Entity
public abstract class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
