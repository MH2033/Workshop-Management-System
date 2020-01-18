package com.project.workshopmanagment.entity.workshop;

import com.project.workshopmanagment.entity.enums.WorkshopRelationType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class WorkshopRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    private Workshop workshop;

    @NotNull(message = "WorkshopRelationType cannot be empty")
    private WorkshopRelationType workshopRelationType;


    public WorkshopRelation() {
    }

    public WorkshopRelation(Long id, Workshop workshop, WorkshopRelationType workshopRelationType) {
        this.id = id;
        this.workshop = workshop;
        this.workshopRelationType = workshopRelationType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Workshop getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Workshop workshop) {
        this.workshop = workshop;
    }

    public WorkshopRelationType getWorkshopRelationType() {
        return workshopRelationType;
    }

    public void setWorkshopRelationType(WorkshopRelationType workshopRelationType) {
        this.workshopRelationType = workshopRelationType;
    }
}
