package com.project.workshopmanagment.entity.workshop;

import com.project.workshopmanagment.entity.RegistrationForm;
import com.project.workshopmanagment.entity.enums.WorkshopState;
import com.project.workshopmanagment.entity.form.Answer;
import com.project.workshopmanagment.entity.form.Respondable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class TakenWorkshop extends Respondable {

    @NotNull(message = "WorkshopGroup cannot be empty")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "WorkshopGroup_id")
    private WorkshopGroup workshopGroup;

    @NotNull(message = "RegistrationForm cannot be empty")
    @OneToOne(cascade = CascadeType.MERGE)
    private RegistrationForm registrationForm;

    private WorkshopState workshopState;

    public TakenWorkshop() {
    }

    public TakenWorkshop(Long id, List<Answer> answer) {
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
