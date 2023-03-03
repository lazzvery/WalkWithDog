package com.prj.web.awesome.user.service;

import com.prj.web.awesome.user.dto.HeartDTO;
import com.prj.web.awesome.user.dto.HeartItemDTO;

import java.util.List;

public interface HeartService {
    List<HeartItemDTO> findHeartItem(String user_id);
    HeartDTO findHeart(int item_id, String user_id);
    void save(HeartDTO heartDTO);
    void delete(int item_id);
}
