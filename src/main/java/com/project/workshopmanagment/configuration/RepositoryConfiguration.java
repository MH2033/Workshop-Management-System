package com.project.workshopmanagment.configuration;

import com.project.workshopmanagment.entity.Organizer;
import com.project.workshopmanagment.entity.Participant;
import com.project.workshopmanagment.handler.GraderEventHandler;
import com.project.workshopmanagment.handler.OrganizerEventHandler;
import com.project.workshopmanagment.handler.ParticipantEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {
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
}
