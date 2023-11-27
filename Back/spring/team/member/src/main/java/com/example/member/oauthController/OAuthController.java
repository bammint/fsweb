package com.example.member.oauthController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OAuthController {
    @GetMapping("/loginForm")
    public String home(){
        return "login/loginForm";
    }

    @GetMapping("/private")
    public String privatePage(){
        return "login/privatePage";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "login/adminPage";
    }
}
