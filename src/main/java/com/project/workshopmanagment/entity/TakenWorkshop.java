package com.project.workshopmanagment.entity;

import com.project.workshopmanagment.entity.enums.WorkshopState;

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

    private WorkshopState wokshopState;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public WorkshopGroup getWorkshopGroup() {
        return workshopGroup;
    }

    public RegistrationForm getRegistrationForm() {
        return registrationForm;
    }

    public WorkshopState getWokshopState() {
        return wokshopState;
    }

    public void setWorkshopGroup(WorkshopGroup workshopGroup) {
        this.workshopGroup = workshopGroup;
    }

    public void setRegistrationForm(RegistrationForm registrationForm) {
        this.registrationForm = registrationForm;
    }

    public void setWokshopState(WorkshopState wokshopState) {
        this.wokshopState = wokshopState;
    }
}
