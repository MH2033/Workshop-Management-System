package com.project.workshopmanagment.handler.role;

import com.project.workshopmanagment.entity.role.Participant;
import com.project.workshopmanagment.entity.role.Role;
import com.project.workshopmanagment.security.JWTAuthorizationFilter;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.validation.Valid;

@RepositoryEventHandler
public class ParticipantEventHandler {

    private Long id;

    @HandleBeforeCreate
    public void handleGraderSave(@Valid Participant participant) {
        id = Long.parseLong(JWTAuthorizationFilter.loginPrincipal.getId());
        if(participant.getUser().getId() != id)
            throw new RuntimeException("Access denied");
        for(Role role : participant.getUser().getRoles()){
            if(role instanceof Participant)
                throw new RuntimeException("User already has a participant role");
        }
    }
}
