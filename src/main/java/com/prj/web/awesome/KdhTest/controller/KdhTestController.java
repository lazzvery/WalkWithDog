package com.prj.web.awesome.KdhTest.controller;

import com.prj.web.awesome.KdhTest.dto.KdhTestDto;
import com.prj.web.awesome.KdhTest.payload.in.dto.KdhTestInDto;
import com.prj.web.awesome.KdhTest.payload.out.dto.KdhTestOutDto;
import com.prj.web.awesome.KdhTest.service.KdhTestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Log4j2
public class KdhTestController {

    private final KdhTestService service;

    /**
     *  고객 가입 시 사용자 ID 중복 체크
     * */
    public KdhTestOutDto chkUserId(KdhTestInDto inDto) {

        KdhTestDto rstDto = service.chkUserId(
                                    KdhTestDto.builder()
                                            .userId(inDto.getUserId())
                                            .build()
                            );


        String resultMsg = "";

        if(rstDto != null && !StringUtils.isEmpty(rstDto.getUserId())) {
            resultMsg = "ID가 존재 합니다. 다른 ID를 사용하세요.";
        } else {
            resultMsg = "사용 가능한 ID 입니다.";

            return KdhTestOutDto.builder()
                    .resultMsg(resultMsg).build();
        }

        return KdhTestOutDto.builder()
                    .userId(rstDto.getUserId())
                    .userName(rstDto.getUserName())
                    .resultMsg(resultMsg)
                .build();
    }
}
