package com.example.teradatatest.dto.request;

import com.example.teradatatest.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequest {
    private String userId;
    private String userName;
    private String pw;
    private String email;

    public Member toMember() {
        return new Member(null, userId, userName, pw, email);
    }
}
