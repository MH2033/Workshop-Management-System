package com.project.workshopmanagment.service;


import com.project.workshopmanagment.entity.User;
import com.project.workshopmanagment.security.LoginUser;
import com.project.workshopmanagment.security.Token;

public interface UserService {
    public User save(User user);

    public User findByEmail(String email);

    public Iterable<User> findAll();

    public Token login(LoginUser loginUser);
}
