package com.project.workshopmanagment.handler;

import com.project.workshopmanagment.entity.ContactPoint;
import com.project.workshopmanagment.security.JWTAuthorizationFilter;
import org.springframework.data.rest.core.annotation.*;

import javax.validation.Valid;

@RepositoryEventHandler
public class ContactPointEventHandler {

    private Long id;

    @HandleBeforeSave
    @HandleBeforeLinkSave
    @HandleBeforeCreate
    @HandleBeforeDelete
    public void handleContactPintBeforeCreate(@Valid ContactPoint contactPoint){
        id = Long.parseLong(JWTAuthorizationFilter.loginPrincipal.getId());
        if(contactPoint.getUser().getId() != id)
            throw new RuntimeException("Access denied");
    }
}
