package com.prj.web.awesome.KdhTest.api;

import com.prj.web.awesome.KdhTest.controller.KdhTestController;
import com.prj.web.awesome.KdhTest.payload.in.KdhTestInPayload;
import com.prj.web.awesome.KdhTest.payload.out.KdhTestOutPayload;
import com.prj.web.awesome.KdhTest.payload.out.dto.KdhTestOutDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class KdhTestApi {

    private final KdhTestController controller;

    /**
     *      Payload 내에 Dto를 선언 해주고, Payload는 dto와 한쌍이다.
     *      In Payload, In Dto 는 UI에서 넘겨주는 데이터를 받는 역할
     *      Out Payload, Out Dto 는 UI에 보내줄 용도
     *
     *      api -> controller -> service -> mapper -> mybatis xml
     * */
    @Tag(name = "ID 중복 확인", description = "중복 시 메세지 text를 setting")
    @PostMapping(path = "/chkId")
    public KdhTestOutPayload chkUserId(@RequestBody KdhTestInPayload inDs) {
        return KdhTestOutPayload.builder()
                .kdhTestOutDto(
                        controller.chkUserId(inDs.getKdhTestInDto())
                ).build();
    }


}
