package com.masglobalconsulting.javatest.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employees-view")
public class ViewController {

    @GetMapping("/home")
    public String greeting( Model model) {
        return "home";
    }



}
