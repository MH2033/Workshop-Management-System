package com.project.workshopmanagment.handler;

import com.project.workshopmanagment.entity.Grader;
import com.project.workshopmanagment.entity.Organizer;
import com.project.workshopmanagment.entity.Role;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.validation.Valid;

@RepositoryEventHandler
public class OrganizerEventHandler {
    @HandleBeforeCreate
    public void handleGraderSave(@Valid Organizer organizer) {
        for(Role role : organizer.getUser().getRoles()){
            if(role instanceof Organizer)
                throw new RuntimeException("User already has a organizer role");
        }
    }
}
