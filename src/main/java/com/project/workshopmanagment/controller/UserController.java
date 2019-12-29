package com.project.workshopmanagment.controller;

import com.project.workshopmanagment.entity.User;
import com.project.workshopmanagment.repository.UserRepository;
import com.project.workshopmanagment.security.JWTAuthorizationFilter;
import com.project.workshopmanagment.security.LoginUser;
import com.project.workshopmanagment.security.Token;
import com.project.workshopmanagment.service.UserService;
import com.project.workshopmanagment.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;

@RepositoryRestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<User> register(@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            return new ResponseEntity<User>(new User(), HttpStatus.BAD_REQUEST);
        }

        if (userService.findByEmail(user.getEmail()) != null) {
            return new ResponseEntity<User>(new User(), HttpStatus.CONFLICT);
        }

        User u = new User();
        u.setUsername(u.getUsername());
        u.setHashedPassword(bCryptPasswordEncoder.encode(user.getHashedPassword()));
        u.setEmail(user.getEmail());
        u.setBirthDate(user.getBirthDate());
        u.setGender(user.getGender());
        u.setPhoneNumber(user.getPhoneNumber());
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setNationalCode(user.getNationalCode());

        return new ResponseEntity<>(userRepository.save(u), HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public Token login(@RequestBody LoginUser loginUser) {
        if (userService.login(loginUser) != null)
            return userService.login(loginUser);

        return null;
    }
}