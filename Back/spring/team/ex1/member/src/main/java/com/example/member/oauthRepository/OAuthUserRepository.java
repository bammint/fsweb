package com.example.member.oauthRepository;

import com.example.member.oauthEntity.OAuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OAuthUserRepository extends JpaRepository<OAuthUser,Long> {
    Optional<OAuthUser> findUserByEmailAndProvider(String email, String provider);
}
