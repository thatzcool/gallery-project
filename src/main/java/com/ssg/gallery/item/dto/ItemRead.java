package com.ssg.gallery.item.dto;

//상품 조회 DTO
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

public class ItemRead {
      private Integer id;
      private String name;
      private String img_path;
      private Integer price;
      private Integer discount_per;
}
