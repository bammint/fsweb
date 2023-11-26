package com.example.login.client;

import com.example.login.OAuth.OAuthProvider;
import org.springframework.util.MultiValueMap;

public interface OAuthLoginParams {
    OAuthProvider oAuthProvider();
    MultiValueMap<String,String> makeBody();
}
