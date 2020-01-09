package com.project.workshopmanagment.handler.role;

import com.project.workshopmanagment.entity.role.Participant;
import com.project.workshopmanagment.entity.role.Role;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.validation.Valid;

@RepositoryEventHandler
public class ParticipantEventHandler {
    @HandleBeforeCreate
    public void handleGraderSave(@Valid Participant participant) {
        for(Role role : participant.getUser().getRoles()){
            if(role instanceof Participant)
                throw new RuntimeException("User already has a participant role");
        }
    }
}
