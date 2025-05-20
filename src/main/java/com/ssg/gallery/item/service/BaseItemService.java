package com.ssg.gallery.item.service;

import com.ssg.gallery.item.dto.ItemRead;
import com.ssg.gallery.item.entity.Item;
import com.ssg.gallery.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   //비지니스 로직을 처리하는 서비스 하는 클래스 임을 표기
@RequiredArgsConstructor  //빈을 간편하게 의존성 주입하기 위해 사용된 생성자 어노테이션

public class BaseItemService implements ItemService{

    private final ItemRepository itemRepository;  // 스프링 컨테이너에 의해 의존성 주입될 상품 레파지토리 필드

    @Override
    public List<ItemRead> findAll() {
        return itemRepository.findAll().stream().map(Item::toRead).toList();
    }

    @Override
    public List<ItemRead> findAll(List<Integer> ids) {
        return itemRepository.findAllByIdIn(ids).stream().map(Item::toRead).toList();
    }
}
