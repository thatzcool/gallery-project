package com.ssg.gallery.item.entity;

import com.ssg.gallery.item.dto.ItemRead;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter   //모든 필드의 게터를 자동으로 생성
@Entity   //JPA에 의해 관리되는 엔티티
@Table(name="items")    //매핑된 데이터베이스 테이블의 정보
public class Item {

    @Id   // @Id 애너테이션을 지정하여 해당 필드가 기본키이며, 테이블의 기본키 컬럼과 매핑을 의미
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // 기본키 값을 데이터베이스가 자동으로 증가시켜 생성하도록 한다.
    private Integer id;

    //상품의 이름 필드 @Column은 해당 필드가 테이블의 name컬럼과 매핑된다. 설정 가능한 값의 최대길이는 50이고, null을 허용하지 않는다.
    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String img_path;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer discount_per;

    //생성 일시 필드 , null값을 허용하지 않고 최초 값 입력 후에는 수정되지 않는다.
    @Column(nullable = false , updatable = false)
    @CreationTimestamp    //데이터 삽입 시 값이 없다면 현재 시각이 입력되도록 한다.
    private LocalDateTime created;

    //상품 조회 DTO 변환 메소드
      public ItemRead toRead() {
          return ItemRead.builder()
                  .id(id)
                  .name(name)
                  .img_path(img_path)
                  .price(price)
                  .discount_per(discount_per)
                  .build();
      }

}
