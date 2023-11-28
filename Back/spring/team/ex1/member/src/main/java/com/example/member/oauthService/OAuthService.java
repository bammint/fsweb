package com.example.member.oauthService;

import com.example.member.oauthAttributes.OAuthAttributes;
import com.example.member.oauthDto.OAuthUserDto;
import com.example.member.oauthEntity.OAuthUser;
import com.example.member.oauthRepository.OAuthUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class OAuthService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final OAuthUserRepository oAuthUserRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService oAuth2UserService = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = oAuth2UserService.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId(); // 로그인을 수행한 서비스의 이름

        String userNameAttributeName = userRequest
                .getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUserNameAttributeName(); // PK가 되는 정보

        Map<String, Object> attributes = oAuth2User.getAttributes(); // 사용자가 가지고 있는 정보

        OAuthUserDto oAuthUserDto = OAuthAttributes.extract(registrationId, attributes);
        oAuthUserDto.setProvider(registrationId);

        updateOrSaveUser(oAuthUserDto);

        Map<String, Object> customAttribute =
                getCustomAttribute(registrationId, userNameAttributeName, attributes, oAuthUserDto);

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("USER")),
                customAttribute,
                userNameAttributeName);
    }

    public Map getCustomAttribute(String registrationId,
                                  String userNameAttributeName,
                                  Map<String, Object> attributes,
                                  OAuthUserDto oAuthUserDto) {
        Map<String, Object> customAttribute = new ConcurrentHashMap<>();

        customAttribute.put(userNameAttributeName, attributes.get(userNameAttributeName));
        customAttribute.put("provider", registrationId);
        customAttribute.put("name", oAuthUserDto.getUsername());
        customAttribute.put("email", oAuthUserDto.getEmail());

        return customAttribute;
    }

    public OAuthUser updateOrSaveUser(OAuthUserDto oAuthUserDto) {
        OAuthUser oAuthUser = oAuthUserRepository
                .findUserByEmailAndProvider(oAuthUserDto.getEmail(), oAuthUserDto.getProvider())
                .map(value -> value.updateUser(oAuthUserDto.getUsername(), oAuthUserDto.getEmail()))
                .orElse(oAuthUserDto.toEntity());

        return oAuthUserRepository.save(oAuthUser);
    }
}
