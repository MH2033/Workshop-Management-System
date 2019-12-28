package com.project.workshopmanagment.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.File;
import java.util.List;

@Entity
public class Workshop {
    @Id
    private Integer id;
    private String workshopTitle;
    private int Price;
    File image;
    //private WorkshopRelationship[] workshopRelationships;
    @OneToMany(mappedBy = "workshop")
    private List<OfferedWorkshop> offeredWorkshops;
}