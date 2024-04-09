package com.example.teradatatest.service;

import com.example.teradatatest.dto.request.MemberRequest;
import com.example.teradatatest.dto.response.MemberResponse;
import com.example.teradatatest.entity.Member;
import com.example.teradatatest.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
    final private MemberRepository memberRepository;

    public ResponseEntity<MemberResponse> createMember(MemberRequest memberRequest) {
        return ResponseEntity.ok(new MemberResponse(memberRepository.save(memberRequest.toMember())));
    }
    public ResponseEntity<List<MemberResponse>> readAllMember() {
        List<MemberResponse> memberResponseList = memberRepository.findAll().stream().map(MemberResponse::new).collect(Collectors.toList());
        System.out.println(memberResponseList);
        return ResponseEntity.ok(memberResponseList);
    }
    public ResponseEntity<MemberResponse> readMemberByUserId(String userId) {
        System.out.println(userId);
        return ResponseEntity.ok(new MemberResponse(memberRepository.findByUserId(userId)));
    }
    public ResponseEntity<MemberResponse> updateMember(Member member) {
        Boolean isPresent = memberRepository.existsAllByUserIdAndPw(member.getUserId(), member.getPw());
        if (isPresent) {
            return ResponseEntity.ok(new MemberResponse(memberRepository.save(member)));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    public ResponseEntity<Void> deleteMember(Member member) {
        Boolean isPresent = memberRepository.existsAllByUserIdAndPw(member.getUserId(), member.getPw());
        if (isPresent) {
            memberRepository.deleteByUserIdAndPw(member.getUserId(), member.getPw());
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
