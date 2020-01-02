package com.project.workshopmanagment.handler;


import com.project.workshopmanagment.entity.*;
import com.project.workshopmanagment.entity.enums.WorkshopState;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.validation.Valid;

@RepositoryEventHandler
public class OfferdWorkshopHandler {
    @HandleBeforeCreate
    public void handlerWorkshopPrerequisite(@Valid RegistrationForm registrationForm, @Valid Participant participant){
        for (RegistrationForm i : participant.getRegistrationForms()){
            for (WorkshopRelation j : registrationForm.getDesiredWorkshop().getWorkshop().getWorkshopRelation())
                if (j.getWorkshop().equals(i.getTakenWorkshop().getWorkshopGroup().getOfferedWorkshop().getWorkshop()))
                if (i.getTakenWorkshop().getWokshopState().equals(WorkshopState.PASS)){
                    continue;
                }else{
                    throw new RuntimeException("Don't Pass all Relation Workshop");
                }
        }
    }
}
