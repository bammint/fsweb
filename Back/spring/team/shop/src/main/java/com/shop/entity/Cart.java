package com.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@Getter
@Setter
@ToString
public class Cart extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public static Cart createCart(Member member){
        Cart cart = new Cart();
        cart.setMember(member);
        return cart;
    }
    // 회원 한명당 1개의 장바구니를 갖으므로 처음 장바구니에 상품을 담을 때
    // 해당 회원의 장바구니를 생성 해줘야함
    // Cart클래스에 회원 엔티티를 파라미터로 받아서 장바구니 엔티티 생성
}
// 매핑을 해주면
// 장바구니 엔티티를 조회하면서 회원 엔티티
// 정보도 동시에 가져올 수 있다

// 즉시 로딩
// cart 테이블과 member 테이블을 조인해서 가져오는
// 쿼리문이 실행
// cart 엔티티를 조회하면 member 엔티티도 동시에 가져오는 것임
// 엔티티를 조회할 때 해당 엔티티와 매핑된 엔티티도 한 번에
// 조회하는 것을 '즉시 로딩' 이라고 한다