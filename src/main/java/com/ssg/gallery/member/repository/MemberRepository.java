package com.ssg.gallery.member.repository;

import com.ssg.gallery.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Integer> {

    //아이디와 패스워드로 회원 정보를 조회
    Optional<Member> findByLoginIdAndLoginPw(String loginId, String loginPw);
}


// 조회된 회원이 없을 수도 있기 때문에 리턴 타입을 Optional 로 지정한다. Optional을 사용하면 null을 안전하게 처리하고
// 명시적으로 값이 없읍을 나타낼 수 있기 때문이다.