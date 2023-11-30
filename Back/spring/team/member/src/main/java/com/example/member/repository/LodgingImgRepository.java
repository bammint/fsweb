package com.example.member.repository;

import com.example.member.entity.ItemImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LodgingImgRepository extends JpaRepository<ItemImg, Long> {
    List<ItemImg> findByLodgingIdOrderByIdAsc(Long lodgingId);

    ItemImg findBylodgingIdAndRepimgYn(Long lodgingId, String repimgYn);

    // findBy 뒤에 조건을 붙이면 , 이를 해석하여 데이터베이스 조회 조건 자동 생성
    // itemId : 조회할 ItemImg 엔티티의 itemId 값입니다.
    // repimgYn : 조회할 ItemImg 엔티티의 repimgYn 값입니다.
}