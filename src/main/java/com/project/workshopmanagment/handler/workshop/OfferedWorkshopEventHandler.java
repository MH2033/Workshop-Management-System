package com.project.workshopmanagment.handler.workshop;

import com.project.workshopmanagment.entity.workshop.OfferedWorkshop;
import com.project.workshopmanagment.entity.workshop.WorkshopGroup;
import com.project.workshopmanagment.repository.wokrshop.WorkshopGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.*;

import javax.validation.Valid;

@RepositoryEventHandler
public class OfferedWorkshopEventHandler {

    @Autowired
    WorkshopGroupRepository workshopGroupRepository;

    @HandleAfterCreate
    public void handleOfferedWorkshopSave(@Valid OfferedWorkshop offeredWorkshop){
        WorkshopGroup workshopGroup = new WorkshopGroup();
        workshopGroup.setGroupId("0");
        workshopGroup.setOfferedWorkshop(offeredWorkshop);
        workshopGroupRepository.save(workshopGroup);
    }

}
