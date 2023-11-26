package com.example.login.client;

import com.example.login.OAuth.OAuthProvider;

public interface OAuthInfoResponse {
    String getEmail();
    String getNickname();
    OAuthProvider getOAuthProvider();
}
