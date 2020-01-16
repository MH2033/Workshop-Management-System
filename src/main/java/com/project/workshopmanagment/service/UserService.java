package com.project.workshopmanagment.service;


import com.project.workshopmanagment.entity.User;
import com.project.workshopmanagment.security.LoginUser;
import com.project.workshopmanagment.security.Token;

public interface UserService {

    public User findByEmail(String email);

    public Token login(LoginUser loginUser);

    public User findByUsername(String userName);

}