package com.project.workshopmanagment.configuration;

import com.project.workshopmanagment.handler.*;
import com.project.workshopmanagment.handler.form.AnswerEventHandler;
import com.project.workshopmanagment.handler.role.GraderEventHandler;
import com.project.workshopmanagment.handler.role.OrganizerEventHandler;
import com.project.workshopmanagment.handler.role.ParticipantEventHandler;
import com.project.workshopmanagment.handler.role.SysAdminEventHandler;
import com.project.workshopmanagment.handler.workshop.OfferedWorkshopEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    public RepositoryConfiguration(){
        super();
    }

    @Bean
    GraderEventHandler graderEventHandler() {
        return new GraderEventHandler();
    }

    @Bean
    OrganizerEventHandler organizerEventHandler() {
        return new OrganizerEventHandler();
    }

    @Bean
    ParticipantEventHandler participantEventHandler() {
        return new ParticipantEventHandler();
    }

    @Bean
    SysAdminEventHandler sysAdminEventHandler() {
        return new SysAdminEventHandler();
    }

    @Bean
    OfferedWorkshopEventHandler offeredWorkshopEventHandler(){
        return new OfferedWorkshopEventHandler();
    }

    @Bean
    RegistrationFormEventHandler registrationFormEventHandler(){
        return new RegistrationFormEventHandler();
    }

    @Bean
    GraderRequestEventHandler graderRequestEventHandler(){
        return new GraderRequestEventHandler();
    }

    @Bean
    ContactPointEventHandler contactPointEventHandler(){
        return new ContactPointEventHandler();
    }

    @Bean
    AnswerEventHandler answerEventHandler(){
        return new AnswerEventHandler();
    }

    @Bean
    UserEventHandler userEventHandler(){ return new UserEventHandler();}
}
