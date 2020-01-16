package com.project.workshopmanagment.service.impl;


import com.project.workshopmanagment.entity.User;
import com.project.workshopmanagment.repository.UserRepository;
import com.project.workshopmanagment.security.LoginPrincipal;
import com.project.workshopmanagment.security.LoginUser;
import com.project.workshopmanagment.security.Token;
import com.project.workshopmanagment.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.project.workshopmanagment.security.SecurityConstants.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByUsername(String userName){
        return userRepository.findByUsername(userName);
    }
    @Override
    public Token login(LoginUser loginUser) {
        User user = findByEmail(loginUser.getEmail());
        if (user == null) {
            user = findByUsername(loginUser.getEmail());
        }
        System.out.println(bCryptPasswordEncoder.matches(loginUser.getPassword(), user.getHashedPassword()));
        if (user == null || !bCryptPasswordEncoder.matches(loginUser.getPassword(), user.getHashedPassword())) {
            throw new ResourceNotFoundException("User not found");
        }
        LoginPrincipal loginPrincipal = new LoginPrincipal(user.getId().toString(), user.getHashedPassword(), user.getEmail());
        Map<String, Object> claims = new HashMap<>();
        if (loginUser.isRememberMe()) {
            claims.put("principal", loginPrincipal);
            String token = Jwts.builder()
                    .setSubject(user.getEmail())
                    .setClaims(claims)
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_REMEMBERME.longValue()))
                    .signWith(SignatureAlgorithm.HS512, SECRET_KEY.getBytes())
                    .compact();

            return new Token(TOKEN_PREFIX + token);
        }else {

            claims.put("principal", loginPrincipal);
            String token = Jwts.builder()
                    .setSubject(user.getEmail())
                    .setClaims(claims)
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.HS512, SECRET_KEY.getBytes())
                    .compact();

            return new Token(TOKEN_PREFIX + token);
        }
    }
}