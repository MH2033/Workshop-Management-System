package com.project.workshopmanagment.handler;

import com.project.workshopmanagment.entity.Grader;
import com.project.workshopmanagment.entity.Role;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.Valid;

@RepositoryEventHandler
public class GraderEventHandler {
    @HandleBeforeCreate
    public void handleGraderSave(@Valid Grader grader) {
        for(Role role : grader.getUser().getRoles()){
            if(role instanceof Grader)
                throw new RuntimeException("User already has a grader role");
        }
    }
}
