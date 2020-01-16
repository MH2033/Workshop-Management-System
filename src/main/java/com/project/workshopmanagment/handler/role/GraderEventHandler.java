package com.project.workshopmanagment.handler.role;

import com.project.workshopmanagment.entity.role.Grader;
import com.project.workshopmanagment.entity.role.Role;
import com.project.workshopmanagment.security.JWTAuthorizationFilter;
import org.springframework.data.rest.core.annotation.*;

import javax.validation.Valid;

@RepositoryEventHandler
public class GraderEventHandler {

    private Long id;

    @HandleBeforeCreate
    public void handleGraderSave(@Valid Grader grader) {
        id = Long.parseLong(JWTAuthorizationFilter.loginPrincipal.getId());
        if(grader.getUser().getId() != id)
            throw new RuntimeException("Access denied");
        for(Role role : grader.getUser().getRoles()){
            if(role instanceof Grader)
                throw new RuntimeException("User already has a grader role");
        }
    }
}
