package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public RegistrationController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/registration")
    public String getReg() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user) {
        if (userServiceImpl.findUserByEmail(user.getEmail()) != null) {
            return "registration";
        }
        userServiceImpl.addUser(user);
        return "redirect:/login";
    }
}
