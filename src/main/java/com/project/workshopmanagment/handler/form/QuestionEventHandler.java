package com.project.workshopmanagment.handler.form;

import com.project.workshopmanagment.entity.User;
import com.project.workshopmanagment.entity.form.Question;
import com.project.workshopmanagment.repository.UserRepository;
import com.project.workshopmanagment.security.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.validation.Valid;
import java.util.Optional;

@RepositoryEventHandler
public class QuestionEventHandler {
    @Autowired
    UserRepository userRepository;

    @HandleBeforeCreate
    public void handleQuestionsBeforeSave(@Valid Question question){
        Optional<User> user = userRepository.findById(Long.parseLong(JWTAuthorizationFilter.loginPrincipal.getId()));
        if(!question.getForm().getOfferedWorkshop().getOrganizer().getUser().equals(user.get())){
            throw new RuntimeException("Access denied");
        }
    }
}
