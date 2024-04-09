package com.example.teradatatest.repository.querydsl;

import com.example.teradatatest.entity.Member;
import com.example.teradatatest.entity.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MemberRepositoryCustomImpl implements MemberRepositoryCustom{
    final private JPAQueryFactory jpaQueryFactory;

    @Override
    public Member findByUserId(String userId) {
        System.out.println("find by userId");
        QMember member = QMember.member;
        return jpaQueryFactory.selectFrom(member)
                .where(member.userId.eq(userId))
                .fetchOne();
    }

    @Override
    public List<Member> findAllMember() {
        System.out.println("find all");
        QMember member = QMember.member;
        return jpaQueryFactory.selectFrom(member).fetch();
    }
}
