package com.realdolmen.travel.controller;

import com.realdolmen.travel.domain.User;
import com.realdolmen.travel.repository.UserRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;
import java.util.Date;

@Named
@RequestScoped
public class UserController {
    @Inject
    private UserRepository userRepository;

    private Collection<User> users;

    @PostConstruct
    public void initialize() {
        users = userRepository.findAll();
        users.add(new User("Kevin", "Van Robbroeck", new Date()));
    }

    public Collection<User> getUsers() {
        return users;
    }

    public String remove(User user) {
        userRepository.remove(user);
        return "users?faces-redirect=true";
    }
}
