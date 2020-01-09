package com.project.workshopmanagment.entity.role;

import com.project.workshopmanagment.entity.RegistrationForm;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Participant extends Role {
    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL)
    private List<RegistrationForm> registrationForms;

    public Participant() {
    }

    public Participant(List<RegistrationForm> registrationForms) {
        this.registrationForms = registrationForms;
    }

    public List<RegistrationForm> getRegistrationForms() {
        return registrationForms;
    }

    public void setRegistrationForms(List<RegistrationForm> registrationForms) {
        this.registrationForms = registrationForms;
    }
}
