package com.project.workshopmanagment.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    @OneToMany(mappedBy = "offeredWorkshop", fetch = FetchType.EAGER)
    private List<WorkshopGroup> workshopGroups;

    @ManyToOne
    @JoinColumn(name = "workshop_id")
    private Workshop workshop;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organzier_id")
    private User organizer;

    public OfferedWorkshop() {
    }

    public OfferedWorkshop(Integer id, List<LocalDateTime> offeringDatesAndTimes, String offeringLocation, List<WorkshopGroup> workshopGroups, Workshop workshop, User organizer) {
        this.id = id;
        this.offeringDatesAndTimes = offeringDatesAndTimes;
        this.offeringLocation = offeringLocation;
        this.workshopGroups = workshopGroups;
        this.workshop = workshop;
        this.organizer = organizer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<LocalDateTime> getOfferingDatesAndTimes() {
        return offeringDatesAndTimes;
    }

    public void setOfferingDatesAndTimes(List<LocalDateTime> offeringDatesAndTimes) {
        this.offeringDatesAndTimes = offeringDatesAndTimes;
    }

    public String getOfferingLocation() {
        return offeringLocation;
    }

    public void setOfferingLocation(String offeringLocation) {
        this.offeringLocation = offeringLocation;
    }

    public List<WorkshopGroup> getWorkshopGroups() {
        return workshopGroups;
    }

    public void setWorkshopGroups(List<WorkshopGroup> workshopGroups) {
        this.workshopGroups = workshopGroups;
    }

    public Workshop getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Workshop workshop) {
        this.workshop = workshop;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }
}
