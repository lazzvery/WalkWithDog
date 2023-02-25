package com.prj.web.awesome.KdhTest.payload.out.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KdhTestOutDto {

    @Schema(name = "체크 결과")
    private String resultMsg;

    @Schema(name = "사용자ID", description = "")
    private String userId;

    @Schema(name = "사용자비밀번호", description = "")
    private String userPassword;

    @Schema(name = "사용자이름", description = "")
    private String userName;

    @Schema(name = "사용자 Email", description = "")
    private String userEmail;

    @Schema(name = "Email 수신여부", description = "")
    private String userEmailCheck;

    @Schema(name = "우편번호", description = "")
    private String userPostcode;

    @Schema(name = "주소", description = "")
    private String userAddr;

    @Schema(name = "상세주소", description = "")
    private String userAddr2;

    @Schema(name = "연락처", description = "")
    private String userPhone;

    @Schema(name = "문자 수신 여부", description = "")
    private String userSnsCheck;

    @Schema(name = "성별", description = "")
    private String userGen;

    @Schema(name = "생일", description = "")
    private String userBirthday;

    @Schema(name = "추천인", description = "")
    private String userRid;

    @Schema(name = "관리자여부", description = "")
    private String adminYn;
}
