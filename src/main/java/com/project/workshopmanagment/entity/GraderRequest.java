package com.project.workshopmanagment.entity;

import com.project.workshopmanagment.entity.enums.GraderRequestStatus;
import com.project.workshopmanagment.entity.enums.GraderRole;
import com.project.workshopmanagment.entity.role.Grader;
import com.project.workshopmanagment.entity.workshop.WorkshopGroup;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class GraderRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable=false)
    private Date requestDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    private GraderRequestStatus graderRequestStatus;

    private GraderRole graderRoleInWorkshop;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "group_id")
    private WorkshopGroup workshopGroup;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(updatable = false, name = "grader_id")
    private Grader grader;

    public GraderRequest() {
    }

    public GraderRequest(Long id, GraderRole graderRoleInWorkshop, WorkshopGroup workshopGroup, Grader grader, GraderRequestStatus graderRequestStatus) {
        this.id = id;
        this.graderRoleInWorkshop = graderRoleInWorkshop;
        this.workshopGroup = workshopGroup;
        this.grader = grader;
        this.graderRequestStatus = graderRequestStatus;
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

    public GraderRole getGraderRoleInWorkshop() {
        return graderRoleInWorkshop;
    }

    public void setGraderRoleInWorkshop(GraderRole graderRoleInWorkshop) {
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

    public Grader getGrader() {
        return grader;
    }

    public void setGrader(Grader grader) {
        this.grader = grader;
    }
}
