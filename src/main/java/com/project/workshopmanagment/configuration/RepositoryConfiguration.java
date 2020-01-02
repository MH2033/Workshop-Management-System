package com.project.workshopmanagment.configuration;

import com.project.workshopmanagment.entity.Organizer;
import com.project.workshopmanagment.entity.Participant;
import com.project.workshopmanagment.handler.*;
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
}
