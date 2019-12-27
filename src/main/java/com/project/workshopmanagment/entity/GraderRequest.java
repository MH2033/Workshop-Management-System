package com.project.workshopmanagment.entity;

import com.project.workshopmanagment.entity.enums.GraderRequestStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class GraderRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable=false)
    private Date requestDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    private GraderRequestStatus graderRequestStatus;

    private String graderRoleInWorkshop;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "group_id", updatable = false)
    private WorkshopGroup workshopGroup;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", updatable = false)
    private User user;

    public GraderRequest() {
    }

    public GraderRequest(Long id, String graderRoleInWorkshop, WorkshopGroup workshopGroup, User user) {
        this.id = id;
        this.graderRequestStatus = GraderRequestStatus.ON_HOLD;
        this.graderRoleInWorkshop = graderRoleInWorkshop;
        this.workshopGroup = workshopGroup;
        this.user = user;
        user.getGraderRequests().add(this);
        workshopGroup.getGraderRequests().add(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GraderRequestStatus getGraderRequestStatus() {
        return graderRequestStatus;
    }

    public void setGraderRequestStatus(GraderRequestStatus graderRequestStatus) {
        this.graderRequestStatus = graderRequestStatus;
    }

    public String getGraderRoleInWorkshop() {
        return graderRoleInWorkshop;
    }

    public void setGraderRoleInWorkshop(String graderRoleInWorkshop) {
        this.graderRoleInWorkshop = graderRoleInWorkshop;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public WorkshopGroup getWorkshopGroup() {
        return workshopGroup;
    }

    public void setWorkshopGroup(WorkshopGroup workshopGroup) {
        this.workshopGroup = workshopGroup;
    }

    public User getUser() {
        return user;
    }
}
