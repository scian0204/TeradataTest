package com.example.teradatatest.controller;

import com.example.teradatatest.dto.request.MemberRequest;
import com.example.teradatatest.dto.response.MemberResponse;
import com.example.teradatatest.entity.Member;
import com.example.teradatatest.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/member")
@RequiredArgsConstructor
public class MemberController {
    final private MemberService memberService;

    @PostMapping("")
    public ResponseEntity<MemberResponse> createMember(@RequestBody MemberRequest memberRequest) {
        return memberService.createMember(memberRequest);
    }
    @GetMapping("/list")
    public ResponseEntity<List<MemberResponse>> readAllMember() {
        return memberService.readAllMember();
    }
    @GetMapping("/{userId}")
    public ResponseEntity<MemberResponse> readMemberByUserId(@PathVariable String userId) {
        return memberService.readMemberByUserId(userId);
    }
    @PutMapping("")
    public ResponseEntity<MemberResponse> updateMember(@RequestBody Member member) {
        return memberService.updateMember(member);
    }
    @PostMapping("/delete")
    public ResponseEntity<Void> deleteMember(@RequestBody Member member) {
        return memberService.deleteMember(member);
    }
}
