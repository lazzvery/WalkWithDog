package com.prj.web.awesome.user.service;

import com.prj.web.awesome.user.dto.HeartDTO;

import java.util.List;

public interface HeartService {
    List<HeartDTO> findList(String user_id);
}
