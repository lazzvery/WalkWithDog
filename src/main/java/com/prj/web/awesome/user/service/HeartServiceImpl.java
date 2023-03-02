package com.prj.web.awesome.user.service;

import com.prj.web.awesome.user.dto.HeartDTO;
import com.prj.web.awesome.user.mapperInterface.HeartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeartServiceImpl implements HeartService {

    private final HeartMapper mapper;

    @Override
    public List<HeartDTO> findList(String user_id) {
        return mapper.findList(user_id);
    }
}
