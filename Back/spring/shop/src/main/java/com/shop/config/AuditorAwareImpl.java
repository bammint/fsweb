package com.shop.config;


import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = "";
        if (authentication != null) {
            userId = authentication.getName();
            // 현재 로그인한 사용자의 정보를 조회하여 사용자의 이름을 등록자와 수정자로 지정한다
        }
        return Optional.of(userId);
    }
}
// AuditorAware 인터페이스를 구현 AuditorAwareImpl
// 현재 사용자를 식별
// SecurityContextHolder.getContext().getAuthentication(); 현재의 인증 정보 접근
// authentication.getName(); 현재 사용자의 이름을 가져온다
// 현재 사용자를 찾을 수 없다면 빈 Optional을 반환한다
// 주로 감사(Audit)와 생성자/수정자의 정보를 데이터베이스 테이블에 기록할 때 사용됩니다.