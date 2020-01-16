package com.project.workshopmanagment.entity.workshop;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.File;
import java.util.List;

@Entity
public class Workshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Workshop title cannot be blank")
    private String workshopTitle;


    private File image;

    @OneToMany
    private List<WorkshopRelation> workshopRelation;

    @OneToMany(mappedBy = "workshop", cascade = CascadeType.MERGE)
    private List<OfferedWorkshop> offeredWorkshops;

    public Workshop() {
    }

    public Workshop(Long id, String workshopTitle, File image, List<WorkshopRelation> workshopRelation, List<OfferedWorkshop> offeredWorkshops) {
        this.id = id;
        this.workshopTitle = workshopTitle;
        this.image = image;
        this.workshopRelation = workshopRelation;
        this.offeredWorkshops = offeredWorkshops;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkshopTitle() {
        return workshopTitle;
    }

    public void setWorkshopTitle(String workshopTitle) {
        this.workshopTitle = workshopTitle;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public List<WorkshopRelation> getWorkshopRelation() {
        return workshopRelation;
    }

    public void setWorkshopRelation(List<WorkshopRelation> workshopRelation) {
        this.workshopRelation = workshopRelation;
    }

    public List<OfferedWorkshop> getOfferedWorkshops() {
        return offeredWorkshops;
    }

    public void setOfferedWorkshops(List<OfferedWorkshop> offeredWorkshops) {
        this.offeredWorkshops = offeredWorkshops;
    }
}