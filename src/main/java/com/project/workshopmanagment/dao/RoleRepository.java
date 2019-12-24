package com.project.workshopmanagment.dao;

import com.project.workshopmanagment.entity.Role;
import com.project.workshopmanagment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
