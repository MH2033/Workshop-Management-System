package com.project.workshopmanagment.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class WorkshopGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer databaseId;

    private String groupId;

    @ManyToOne
    @JoinColumn(name = "offeredCourse_id")
    private OfferedWorkshop offeredWorkshop;

    @OneToMany(mappedBy = "workshopGroup")
    private List<GraderRequest> graderRequests;

    public WorkshopGroup() {
    }

    public WorkshopGroup(Integer databaseId, String groupId, OfferedWorkshop offeredWorkshop, List<GraderRequest> graderRequests) {
        this.databaseId = databaseId;
        this.groupId = groupId;
        this.offeredWorkshop = offeredWorkshop;
        this.graderRequests = graderRequests;
    }

    public Integer getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(Integer databaseId) {
        this.databaseId = databaseId;
    }

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
}
