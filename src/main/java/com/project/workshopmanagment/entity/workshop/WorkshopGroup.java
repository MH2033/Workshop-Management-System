package com.project.workshopmanagment.entity.workshop;

import com.project.workshopmanagment.entity.GraderRequest;
import com.project.workshopmanagment.entity.form.Respondable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class WorkshopGroup extends Respondable {

    @NotBlank(message = "GroupId cannot be blank")
    private String groupId;

    public WorkshopGroup() {
    }

    public WorkshopGroup(String groupId, OfferedWorkshop offeredWorkshop, List<GraderRequest> graderRequests, List<TakenWorkshop> takenWorkshops) {
        this.groupId = groupId;
        this.offeredWorkshop = offeredWorkshop;
        this.graderRequests = graderRequests;
        this.takenWorkshops = takenWorkshops;
    }

    @NotNull(message = "OfferedWorkshop cannot be empty")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "offeredworkshop_id")
    private OfferedWorkshop offeredWorkshop;

    @OneToMany(mappedBy = "workshopGroup", cascade = CascadeType.ALL)
    private List<GraderRequest> graderRequests;

    @OneToMany(mappedBy = "workshopGroup", cascade = CascadeType.ALL)
    private List<TakenWorkshop> takenWorkshops;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public OfferedWorkshop getOfferedWorkshop() {
        return offeredWorkshop;
    }

    public void setOfferedWorkshop(OfferedWorkshop offeredWorkshop) {
        this.offeredWorkshop = offeredWorkshop;
    }

    public List<GraderRequest> getGraderRequests() {
        return graderRequests;
    }

    public void setGraderRequests(List<GraderRequest> graderRequests) {
        this.graderRequests = graderRequests;
    }

    public List<TakenWorkshop> getTakenWorkshops() {
        return takenWorkshops;
    }

    public void setTakenWorkshops(List<TakenWorkshop> takenWorkshops) {
        this.takenWorkshops = takenWorkshops;
    }
}
