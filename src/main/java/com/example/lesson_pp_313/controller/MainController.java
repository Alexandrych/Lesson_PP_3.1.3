package com.example.lesson_pp_313.controller;

import com.example.lesson_pp_313.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getMainPage(Model model) {
        model.addAttribute("count", userService.getUsersCount());
        return "redirect:/admin";
    }
}
