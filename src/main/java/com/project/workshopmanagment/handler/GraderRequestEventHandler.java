package com.project.workshopmanagment.handler;

import com.project.workshopmanagment.entity.GraderRequest;
import com.project.workshopmanagment.entity.enums.GraderRequestStatus;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeLinkSave;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.validation.Valid;
import java.util.Date;

@RepositoryEventHandler
public class GraderRequestEventHandler {



    @HandleBeforeSave
    @HandleBeforeLinkSave
    @HandleBeforeCreate
    public void handleGraderRequestCreate(@Valid GraderRequest graderRequest) {
        for(GraderRequest g: graderRequest.getGrader().getGraderRequests()){
            if(g.getWorkshopGroup().getOfferedWorkshop().equals(graderRequest.getWorkshopGroup().getOfferedWorkshop()))
                throw new RuntimeException("You have already filed a GraderRequest for this workshop");
            for(Date d1: g.getWorkshopGroup().getOfferedWorkshop().getOfferingDatesAndTimes()){
                for(Date d2: graderRequest.getWorkshopGroup().getOfferedWorkshop().getOfferingDatesAndTimes()){
                    if(d1.compareTo(d2) == 0
                            && g.getGraderRequestStatus().equals(GraderRequestStatus.ACCEPTED)) {
                        throw new RuntimeException("GraderRequest is in conflict with your previously approved GraderRequests");
                    }
                    else if(d1.compareTo(d2) > 0 &&
                            d1.toInstant().isBefore(d2.toInstant().plusSeconds(graderRequest.getWorkshopGroup().getOfferedWorkshop().getDuration().getSeconds()))
                            && g.getGraderRequestStatus().equals(GraderRequestStatus.ACCEPTED)){
                        throw new RuntimeException("GraderRequest is in conflict with your previously approved GraderRequests");
                    }
                    else if(d2.compareTo(d1) > 0 &&
                            d2.toInstant().isBefore(d1.toInstant().plusSeconds(g.getWorkshopGroup().getOfferedWorkshop().getDuration().getSeconds()))
                            && g.getGraderRequestStatus().equals(GraderRequestStatus.ACCEPTED)){
                        throw new RuntimeException("GraderRequest is in conflict with your previously approved GraderRequests");
                    }
                }
            }
        }
        graderRequest.setGraderRequestStatus(GraderRequestStatus.ON_HOLD);
    }

    @HandleBeforeSave
    public void handleGraderRequestSave(@Valid GraderRequest graderRequest) {
        if(graderRequest.getGraderRequestStatus().equals(GraderRequestStatus.ACCEPTED)){
            for(GraderRequest g: graderRequest.getGrader().getGraderRequests()){
                for(Date d1: g.getWorkshopGroup().getOfferedWorkshop().getOfferingDatesAndTimes()){
                    for(Date d2: graderRequest.getWorkshopGroup().getOfferedWorkshop().getOfferingDatesAndTimes()){
                        if(d1.compareTo(d2) == 0
                                && g.getGraderRequestStatus().equals(GraderRequestStatus.ON_HOLD)) {
                            g.setGraderRequestStatus(GraderRequestStatus.IN_CONFLICT);
                        }
                        else if(d1.compareTo(d2) > 0 &&
                                d1.toInstant().isBefore(d2.toInstant().plusSeconds(graderRequest.getWorkshopGroup().getOfferedWorkshop().getDuration().getSeconds()))
                                && g.getGraderRequestStatus().equals(GraderRequestStatus.ON_HOLD)){
                            g.setGraderRequestStatus(GraderRequestStatus.IN_CONFLICT);
                        }
                        else if(d2.compareTo(d1) > 0 &&
                                d2.toInstant().isBefore(d1.toInstant().plusSeconds(g.getWorkshopGroup().getOfferedWorkshop().getDuration().getSeconds()))
                                && g.getGraderRequestStatus().equals(GraderRequestStatus.ON_HOLD)){
                            g.setGraderRequestStatus(GraderRequestStatus.IN_CONFLICT);
                        }
                    }
                }
            }
        }
    }

}
