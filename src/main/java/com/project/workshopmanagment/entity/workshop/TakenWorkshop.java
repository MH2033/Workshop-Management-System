package com.project.workshopmanagment.entity.workshop;

import com.project.workshopmanagment.entity.RegistrationForm;
import com.project.workshopmanagment.entity.enums.WorkshopState;
import com.project.workshopmanagment.entity.form.Answer;
import com.project.workshopmanagment.entity.form.Respondable;
import com.project.workshopmanagment.entity.workshop.WorkshopGroup;

import javax.persistence.*;

@Entity
public class TakenWorkshop extends Respondable {
    //@Id
    //private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "offeredWorkshop_id")
    private WorkshopGroup workshopGroup;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "takenWorkshop")
    private RegistrationForm registrationForm;

    private WorkshopState workshopState;

    public TakenWorkshop() {
        super();
    }

    public TakenWorkshop(Long id, Answer answer) {
        super(id, answer);
    }

    public WorkshopGroup getWorkshopGroup() {
        return workshopGroup;
    }

    public RegistrationForm getRegistrationForm() {
        return registrationForm;
    }

    public WorkshopState getWorkshopState() {
        return workshopState;
    }

    public void setWorkshopGroup(WorkshopGroup workshopGroup) {
        this.workshopGroup = workshopGroup;
    }

    public void setRegistrationForm(RegistrationForm registrationForm) {
        this.registrationForm = registrationForm;
    }

    public void setWorkshopState(WorkshopState wokshopState) {
        this.workshopState = wokshopState;
    }
}
