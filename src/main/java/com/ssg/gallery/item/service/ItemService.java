package com.ssg.gallery.item.service;

import com.ssg.gallery.item.dto.ItemRead;

import java.util.List;

public interface ItemService {

       //전체 상품 목록을 조회 : 리턴 타입으로 상품 조회 DTO리스트를 지정
         List<ItemRead>  findAll();


       // 상품 목록 조회(특정 아이디로 리스트 조회)  : 매개변수로 상품의 아이디 리스트를 받아서 리턴타입으로 상품 조회 DTO리스트를 지정
          List<ItemRead> findAll(List<Integer> ids);

}
