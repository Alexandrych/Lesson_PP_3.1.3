package com.example.lesson_pp_313.controller;

import com.example.lesson_pp_313.model.User;
import com.example.lesson_pp_313.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("usersList", userService.getUsers());
        model.addAttribute("modelUser", new User());
        model.addAttribute("rolesList", userService.getRoles());
        return "admin";
    }

    @PostMapping
    public String addUser(@ModelAttribute("modelUser") @Valid User user,
                          BindingResult bindingResult,
                          Model model) {
        model.addAttribute("usersList", userService.getUsers());
        model.addAttribute("rolesList", userService.getRoles());
        return userService.addUser(user, bindingResult);
    }

    @DeleteMapping("/{id}/delete")
    public String deleteUserById(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

    @PatchMapping("/{id}/edit")
    public String updateUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult,
                             Model model) {
        model.addAttribute("rolesList", userService.getRoles());
        return userService.updateUser(user, bindingResult);
    }
}
