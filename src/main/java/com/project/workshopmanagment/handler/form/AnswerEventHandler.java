package com.project.workshopmanagment.handler.form;

import com.project.workshopmanagment.entity.GraderRequest;
import com.project.workshopmanagment.entity.User;
import com.project.workshopmanagment.entity.enums.GraderRequestStatus;
import com.project.workshopmanagment.entity.enums.GraderType;
import com.project.workshopmanagment.entity.form.Answer;
import com.project.workshopmanagment.entity.workshop.TakenWorkshop;
import com.project.workshopmanagment.entity.workshop.Workshop;
import com.project.workshopmanagment.entity.workshop.WorkshopGroup;
import com.project.workshopmanagment.repository.UserRepository;
import com.project.workshopmanagment.security.JWTAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.validation.Valid;
import java.util.Optional;

@RepositoryEventHandler
public class AnswerEventHandler {
    @Autowired
    private UserRepository userRepository;

    @HandleBeforeCreate
    public void answerHandleBeforeSave(@Valid Answer answer){
        Optional<User> u = userRepository.findById(Long.parseLong(JWTAuthorizationFilter.loginPrincipal.getId()));
        if(answer.getRespondable() instanceof TakenWorkshop){
            TakenWorkshop tk = (TakenWorkshop)answer.getRespondable();
            for(GraderRequest gr: tk.getWorkshopGroup().getGraderRequests()) {
                if(gr.getGraderRequestStatus().equals(GraderRequestStatus.ACCEPTED) && u.get().getRoles().contains(gr.getGrader()) && gr.getGraderType().equals(GraderType.HEAD))
                    return;

            }
        }
        if(answer.getRespondable() instanceof WorkshopGroup){
           WorkshopGroup workshopGroup = (WorkshopGroup) answer.getRespondable();
            for(GraderRequest gr: workshopGroup.getGraderRequests()) {
                if(gr.getGraderRequestStatus().equals(GraderRequestStatus.ACCEPTED) && u.get().getRoles().contains(gr.getGrader()) && gr.getGraderType().equals(GraderType.HEAD))
                    return;
            }
        }
        throw new RuntimeException("Access denied");
    }
}
