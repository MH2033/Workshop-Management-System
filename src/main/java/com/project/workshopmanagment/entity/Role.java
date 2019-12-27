package com.project.workshopmanagment.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Role() {
    }

    public Role(Integer id, User user) {
        this.id = id;
        this.user = user;
        user.getRoles().add(this);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
