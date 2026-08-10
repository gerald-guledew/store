package com.gguledew.store.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Value("${spring.application.name}")
    private String appName;

    @Value("nuser.uname")
    private String gname;


    @RequestMapping("/")
    public String index () {
        System.out.println("appName value: "+appName);
        System.out.println("HomeConroller gname value: "+gname);
        return "index.html";
    }
}
