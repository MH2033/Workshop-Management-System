package com.project.workshopmanagment.entity.role;

import com.project.workshopmanagment.entity.workshop.OfferedWorkshop;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Organizer extends Role {
    @OneToMany(mappedBy = "organizer")
    private List<OfferedWorkshop> offeredWorkshop;

    public Organizer() {
    }

    public Organizer(List<OfferedWorkshop> offeredWorkshop) {
        this.offeredWorkshop = offeredWorkshop;
    }

}
