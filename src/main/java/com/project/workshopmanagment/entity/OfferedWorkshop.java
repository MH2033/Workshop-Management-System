package com.project.workshopmanagment.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class OfferedWorkshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;

    @ElementCollection
    private List<LocalDateTime> offeringDatesAndTimes;

    private String offeringLocation;
    //private WorkshopForm[] workshopForms;
    @OneToMany(mappedBy = "offeredWorkshop", cascade = CascadeType.ALL)
    private List<WorkshopGroup> workshopGroups;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(nullable = false, name = "workshop_id")
    private Workshop workshop;

    public OfferedWorkshop() {
    }

    public OfferedWorkshop(Long id, Organizer organizer, List<LocalDateTime> offeringDatesAndTimes, String offeringLocation, List<WorkshopGroup> workshopGroups, Workshop workshop) {
        this.id = id;
        this.organizer = organizer;
        this.offeringDatesAndTimes = offeringDatesAndTimes;
        this.offeringLocation = offeringLocation;
        this.workshopGroups = workshopGroups;
        this.workshop = workshop;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
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
}
