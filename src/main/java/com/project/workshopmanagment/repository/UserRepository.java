package com.project.workshopmanagment.repository;

import com.project.workshopmanagment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
