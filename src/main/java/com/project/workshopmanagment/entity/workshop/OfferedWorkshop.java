package com.project.workshopmanagment.entity.workshop;

import com.project.workshopmanagment.entity.form.Form;
import com.project.workshopmanagment.entity.role.Organizer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.Duration;
import java.util.Date;
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
    private List<Date> offeringDatesAndTimes;

    private Duration duration;

    @NotNull
    @Positive
    private int capacity;

    private String offeringLocation;

    private int price = 0;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offeredWorkshop")
    private List<Form> formList;

    @OneToMany(mappedBy = "offeredWorkshop", cascade = CascadeType.ALL)
    private List<WorkshopGroup> workshopGroups;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(nullable = false, name = "workshop_id")
    private Workshop workshop;

    public OfferedWorkshop() {
    }

    public OfferedWorkshop(Long id, Organizer organizer, List<Date> offeringDatesAndTimes, Duration duration, @NotNull @Positive int capacity, String offeringLocation, int price, List<WorkshopGroup> workshopGroups, Workshop workshop) {
        this.id = id;
        this.organizer = organizer;
        this.offeringDatesAndTimes = offeringDatesAndTimes;
        this.duration = duration;
        this.capacity = capacity;
        this.offeringLocation = offeringLocation;
        this.price = price;
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

    public List<Date> getOfferingDatesAndTimes() {
        return offeringDatesAndTimes;
    }

    public void setOfferingDatesAndTimes(List<Date> offeringDatesAndTimes) {
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

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration courseDuration) {
        this.duration = courseDuration;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
