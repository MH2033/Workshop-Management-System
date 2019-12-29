package com.project.workshopmanagment.repository;

import com.project.workshopmanagment.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
}