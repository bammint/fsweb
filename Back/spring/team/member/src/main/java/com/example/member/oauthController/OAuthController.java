package com.example.member.oauthController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class OAuthController {
    @GetMapping("/login")
    public String home() {
        return "member/login";
    }

    @GetMapping("/private")
    public String privatePage() {
        return "member/privatePage";
    }
    @GetMapping("/admin")
    public String adminPage() {
        return "member/adminPage";
    }
}
