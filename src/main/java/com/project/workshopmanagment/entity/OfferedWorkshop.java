package com.project.workshopmanagment.entity;

import org.springframework.beans.factory.parsing.Location;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class OfferedWorkshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ElementCollection
    private List<LocalDateTime> offeringDatesAndTimes;

    private String offeringLocation;
    //private WorkshopForm[] workshopForms;
    @OneToMany(mappedBy = "offeredWorkshop", fetch = FetchType.LAZY)
    private List<Group> groups;

    @ManyToOne
    @JoinColumn(nullable = false, name = "workshop_id")
    private Workshop workshop;
}
