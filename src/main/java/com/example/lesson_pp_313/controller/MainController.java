package com.example.lesson_pp_313.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping
    public String getMainPage() {
        return "redirect:/user";
    }
}
