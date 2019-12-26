package com.project.workshopmanagment.entity;

import javax.persistence.*;

@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer databaseId;

    private String groupId;

    @ManyToOne
    @JoinColumn(name = "offeredCourse_id")
    private OfferedWorkshop offeredWorkshop;
    //private GraderRequest []graderRequests;
    //private TakenWorkshop []takenWorkshops;
}
