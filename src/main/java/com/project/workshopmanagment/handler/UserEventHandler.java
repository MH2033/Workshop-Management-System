package com.project.workshopmanagment.handler;

import com.project.workshopmanagment.entity.User;
import com.project.workshopmanagment.entity.role.Grader;
import com.project.workshopmanagment.entity.role.Participant;
import com.project.workshopmanagment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;

import javax.validation.Valid;

public class UserEventHandler {
    @Autowired
    UserRepository userRepository;
    @HandleAfterCreate
    public void handleAfterCreate(@Valid User user){
        user.getRoles().add(new Grader());
        user.getRoles().add(new Participant());
        userRepository.save(user);
    }
}
