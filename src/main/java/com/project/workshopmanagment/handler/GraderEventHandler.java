package com.project.workshopmanagment.handler;

import com.project.workshopmanagment.entity.Grader;
import com.project.workshopmanagment.entity.Role;
import com.project.workshopmanagment.security.JWTAuthorizationFilter;
import com.project.workshopmanagment.security.LoginPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.Valid;

@RepositoryEventHandler
public class GraderEventHandler {

    private Long id;

    @HandleBeforeSave
    @HandleBeforeLinkSave
    @HandleBeforeCreate
    @HandleBeforeDelete
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
