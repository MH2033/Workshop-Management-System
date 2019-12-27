package com.project.workshopmanagment.repository;

import com.project.workshopmanagment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
