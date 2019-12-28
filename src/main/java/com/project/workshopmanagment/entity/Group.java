package com.project.workshopmanagment.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer databaseId;

    private String groupId;

    @ManyToOne
    @JoinColumn(name = "offeredCourse_id")
    private OfferedWorkshop offeredWorkshop;

    @OneToMany(mappedBy = "group")
    private List<GraderRequest> graderRequests;
    //private TakenWorkshop []takenWorkshops;
}
