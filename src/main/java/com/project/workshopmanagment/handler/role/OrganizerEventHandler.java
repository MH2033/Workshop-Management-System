package com.project.workshopmanagment.handler.role;

import com.project.workshopmanagment.entity.role.Organizer;
import com.project.workshopmanagment.entity.role.Role;
import com.project.workshopmanagment.security.JWTAuthorizationFilter;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.validation.Valid;

@RepositoryEventHandler
public class OrganizerEventHandler {

    private Long id;

    @HandleBeforeCreate
    public void handleGraderSave(@Valid Organizer organizer) {
        id = Long.parseLong(JWTAuthorizationFilter.loginPrincipal.getId());
        if(organizer.getUser().getId() != id)
            throw new RuntimeException("Access denied");
        for(Role role : organizer.getUser().getRoles()){
            if(role instanceof Organizer)
                throw new RuntimeException("User already has a organizer role");
        }
    }
}
