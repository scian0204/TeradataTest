package com.example.teradatatest.repository.querydsl;

import com.example.teradatatest.entity.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    Member findByUserId(String userId);
    List<Member> findAllMember();
}
