package com.project.workshopmanagment.handler;

import com.project.workshopmanagment.entity.Participant;
import com.project.workshopmanagment.entity.Role;
import com.project.workshopmanagment.entity.SysAdmin;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.validation.Valid;

@RepositoryEventHandler
public class SysAdminEventHandler {
    @HandleBeforeCreate
    public void handleSysAdminSave(@Valid SysAdmin sysAdmin) {
        for(Role role : sysAdmin.getUser().getRoles()){
            if(role instanceof SysAdmin)
                throw new RuntimeException("User already has a sysAdmin role");
        }
    }
}
