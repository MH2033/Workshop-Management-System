package com.project.workshopmanagment.handler;

import com.project.workshopmanagment.entity.OfferedWorkshop;
import com.project.workshopmanagment.entity.WorkshopGroup;
import com.project.workshopmanagment.repository.OfferedWorkshopRepository;
import com.project.workshopmanagment.repository.WorkshopGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
