package com.ssg.gallery.item.repository;

import com.ssg.gallery.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//JpaRepository 인터페이스 확장 : 제너릭 매개변수로 상품Item 과 엔티티의 아이디의 데이터타입을 지정
public interface ItemRepository extends JpaRepository<Item, Integer> {
    //여러 상품아이디로 상품데이터를 조회하는 메서드
    // 이름 끝 부분의 In은 매개변수의 값이 배열이나 리스트 타입일때 해당 값을 모두 포함하는 조건을 의미
    //리턴 타입으로 상품 엔티티의 리스트를 지정한다.

    List<Item> findAllByIdIn(List<Integer> ids);
}
