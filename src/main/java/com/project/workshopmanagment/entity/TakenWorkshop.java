package com.project.workshopmanagment.entity;

import javax.persistence.*;

@Entity
public class TakenWorkshop {
    @Id
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "offeredWorkshop_id")
    private WorkshopGroup workshopGroup;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "takenWorkshop")
    private RegistrationForm registrationForm;


}
