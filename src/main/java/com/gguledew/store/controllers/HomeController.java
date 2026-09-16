package com.gguledew.store.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Value("${spring.application.name}")
    private String appName;

    @Value("nuser.uname")
    private String gname;


    @RequestMapping("/")
    public String index (Model model) {
//        System.out.println("appName value: "+appName);
//        System.out.println("HomeConroller gname value: "+gname);
        model.addAttribute("name", "gerald");
        return "index";
    }
}
