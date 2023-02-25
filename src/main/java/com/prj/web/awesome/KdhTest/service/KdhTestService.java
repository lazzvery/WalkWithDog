package com.prj.web.awesome.KdhTest.service;

import com.prj.web.awesome.KdhTest.dto.KdhTestDto;
import com.prj.web.awesome.KdhTest.mapper.KdhTestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KdhTestService {

    private final KdhTestMapper mapper;

    public KdhTestDto chkUserId(KdhTestDto kdhTestDto) {
        return mapper.chkUserId(kdhTestDto);
    }
}
