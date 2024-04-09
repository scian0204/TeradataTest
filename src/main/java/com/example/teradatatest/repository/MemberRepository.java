package com.example.teradatatest.repository;

import com.example.teradatatest.entity.Member;
import com.example.teradatatest.repository.querydsl.MemberRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer>, MemberRepositoryCustom {
    Boolean existsAllByUserIdAndPw(String userId, String pw);
    Void deleteByUserIdAndPw(String userId, String pw);
}
