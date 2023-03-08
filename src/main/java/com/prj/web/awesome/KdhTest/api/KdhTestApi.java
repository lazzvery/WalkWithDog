package com.prj.web.awesome.KdhTest.api;

import com.prj.web.awesome.KdhTest.controller.KdhTestController;
import com.prj.web.awesome.KdhTest.payload.in.KdhTestInPayload;
import com.prj.web.awesome.KdhTest.payload.out.KdhTestOutPayload;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
@Log4j2
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
        log.info("===========inDs.getKdhTestInDto().getUserId() : {}", inDs.getKdhTestInDto().getUserId());
        return KdhTestOutPayload.builder()
                .kdhTestOutDto(
                        controller.chkUserId(inDs.getKdhTestInDto())
                ).build();
    }


    @Tag(name = "ID 중복 확인 View 호출", description = "KdhTest.Html을 불러온다.")
    @GetMapping(path = "/chkId")
    public ModelAndView resltChkUserId() {

        ModelAndView mv = new ModelAndView();

        mv.setViewName("html/kdhTest/kdhTest");

        return mv;
    }


}
