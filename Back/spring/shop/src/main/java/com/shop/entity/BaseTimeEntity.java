package com.shop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.time.LocalDateTime;

@EntityListeners(value = {AuditingEntityListener.class})
// Auditing 을 적용하기 위한 EntityListeners 어노테이션 추가
@MappedSuperclass // 공통 매핑 정보가 필요할 때
@Getter
@Setter
public abstract class BaseTimeEntity {
    @CreatedDate // 엔티티가 생성되어 저장될 때 시간을 자동으로 저장
    @Column(updatable = false)
    private LocalDateTime regTime;

    @LastModifiedDate // 변경할 때 시간을 자동으로 저장
    private LocalDateTime updateTime;
}
