package com.ssg.gallery.cart.dto;

import com.ssg.gallery.cart.entity.Cart;
import lombok.Getter;

@Getter
public class CartRequest {

    private Integer itemId;   //장바구니에 담을 상품 데이터의 아이디

    // 엔티티 객체로 변환
    public Cart toEntity(Integer memberId) {
        return new Cart(memberId, itemId);
    }
    //장바구니 상품 담기 요청 DTO(CartRuest)를 엔티티 객체로 변환 메소드
    //회원 아이디와 상품아이디를 사용하여 장바구니 엔티티 객체를 생성하고 리턴한다. 이 메서드는 장바구니 서비스에서 데이터를 저장할때 사용된다.
}