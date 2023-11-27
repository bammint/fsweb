package com.example.member.oauthRepository;

import com.example.member.oauthEntity.OAuthMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OAuthMemberRepository extends JpaRepository<OAuthMember, Long> {
    public Optional<OAuthMember> findByName(String name);
}
