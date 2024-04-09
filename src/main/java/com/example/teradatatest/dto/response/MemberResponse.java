package com.example.teradatatest.dto.response;

import com.example.teradatatest.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponse {
    private Integer idx;
    private String userId;
    private String userName;
    private String email;

    public MemberResponse(Member member) {
        this.idx = member.getIdx();
        this.userId = member.getUserId();
        this.userName = member.getUserName();
        this.email = member.getEmail();
    }
}
