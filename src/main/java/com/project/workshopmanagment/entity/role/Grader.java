package com.project.workshopmanagment.entity.role;

import com.project.workshopmanagment.entity.GraderRequest;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Grader extends Role {

    //@NotNull
    @OneToMany(mappedBy = "grader", cascade = CascadeType.ALL)
    private List<GraderRequest> graderRequests;

    public Grader() {
    }

    public Grader(List<GraderRequest> graderRequests) {
        this.graderRequests = graderRequests;
    }

    public List<GraderRequest> getGraderRequests() {
        return graderRequests;
    }

    public void setGraderRequests(List<GraderRequest> graderRequests) {
        this.graderRequests = graderRequests;
    }
}
