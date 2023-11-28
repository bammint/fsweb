package com.example.member.oauthAttributes;

import com.example.member.oauthDto.OAuthUserDto;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

public enum OAuthAttributes {
    GOOGLE("google", (attribute) -> {
        OAuthUserDto oAuthUserDto = new OAuthUserDto();
        oAuthUserDto.setUserName((String)attribute.get("name"));
        oAuthUserDto.setEmail((String)attribute.get("email"));

        return oAuthUserDto;
    }),

    NAVER("naver", (attribute) -> {
        OAuthUserDto userProfile = new OAuthUserDto();

        Map<String, String> responseValue = (Map)attribute.get("response");

        userProfile.setUserName(responseValue.get("name"));
        userProfile.setEmail(responseValue.get("email"));

        return userProfile;
    }),

    KAKAO("kakao", (attribute) -> {

        Map<String, Object> account = (Map)attribute.get("kakao_account");
        Map<String, String> profile = (Map)account.get("profile");

        OAuthUserDto userProfile = new OAuthUserDto();
        userProfile.setUserName(profile.get("nickname"));
        userProfile.setEmail((String)account.get("email"));

        return userProfile;
    });

    private final String registrationId; // 로그인한 서비스(ex) google, naver..)
    private final Function<Map<String, Object>, OAuthUserDto> of; // 로그인한 사용자의 정보를 통하여 UserProfile을 가져옴

    OAuthAttributes(String registrationId, Function<Map<String, Object>, OAuthUserDto> of) {
        this.registrationId = registrationId;
        this.of = of;
    }

    public static OAuthUserDto extract(String registrationId, Map<String, Object> attributes) {
        return Arrays.stream(values())
                .filter(value -> registrationId.equals(value.registrationId))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .of.apply(attributes);
    }
}
