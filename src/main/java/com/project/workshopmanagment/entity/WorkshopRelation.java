package com.project.workshopmanagment.entity;

import com.project.workshopmanagment.entity.enums.WorkshopRelationType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class WorkshopRelation {
    @Id
    private Long id;

    @OneToOne
    private Workshop workshop;

    @NotNull
    private WorkshopRelationType workshopRelationType;


    public WorkshopRelation() {
    }

    public WorkshopRelation(Long id, Workshop workshop, @NotNull WorkshopRelationType workshopRelationType) {
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
