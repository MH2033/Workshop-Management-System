package com.project.workshopmanagment.repository;

import com.project.workshopmanagment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);
    User findByUsername(String userName);

    @PreAuthorize("hasAuthority('ROLE_SYSADMIN')")
    Iterable<User> findAll();
    @PreAuthorize("hasAuthority('ROLE_'+ #id)")
    Optional<User> findById(@PathVariable Long id);
}
