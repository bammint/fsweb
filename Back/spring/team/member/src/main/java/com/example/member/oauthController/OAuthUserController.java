//package com.example.member.oauthController;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/members")
//public class OAuthUserController {
//    @GetMapping("/login/")
//    public String getJson(Authentication authentication) {
//        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
//
//        Map<String, Object> attributes = oAuth2User.getAttributes();
//
//        return attributes.toString();
//    }
//}
