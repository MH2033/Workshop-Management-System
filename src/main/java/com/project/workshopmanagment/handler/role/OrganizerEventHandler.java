package com.project.workshopmanagment.handler.role;

import com.project.workshopmanagment.entity.User;
import com.project.workshopmanagment.entity.role.Organizer;
import com.project.workshopmanagment.entity.role.Role;
import com.project.workshopmanagment.entity.role.SysAdmin;
import com.project.workshopmanagment.repository.UserRepository;
import com.project.workshopmanagment.security.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.validation.Valid;
import java.util.Optional;

@RepositoryEventHandler
public class OrganizerEventHandler {
    @Autowired
    UserRepository userRepository;

    private Long id;

    @HandleBeforeCreate
    public void handleGraderSave(@Valid Organizer organizer) {
        id = Long.parseLong(JWTAuthorizationFilter.loginPrincipal.getId());
        Optional<User> user = userRepository.findById(id);

        if(organizer.getUser().getId() != id){
            for (Role role: user.get().getRoles()){
                if(role instanceof SysAdmin)
                    return;
            }
            throw new RuntimeException("Access denied");
        }
        for(Role role : organizer.getUser().getRoles()){
            if(role instanceof Organizer)
                throw new RuntimeException("User already has a organizer role");
        }
    }
}
