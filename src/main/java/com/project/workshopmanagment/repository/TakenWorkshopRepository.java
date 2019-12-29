package com.project.workshopmanagment.repository;

import com.project.workshopmanagment.entity.TakenWorkshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface TakenWorkshopRepository extends CrudRepository<TakenWorkshop, Long> {
}
