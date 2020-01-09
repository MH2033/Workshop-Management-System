package com.project.workshopmanagment.handler.role;

import com.project.workshopmanagment.entity.role.Role;
import com.project.workshopmanagment.entity.role.SysAdmin;
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
