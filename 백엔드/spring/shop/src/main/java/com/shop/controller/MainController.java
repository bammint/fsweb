package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(Model model, Principal principal){
        if(principal != null){
            model.addAttribute("welcome",principal.getName()+"님, 환영합니다");
        }
        return "main";
    }
}
