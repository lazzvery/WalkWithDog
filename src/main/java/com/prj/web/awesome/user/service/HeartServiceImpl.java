package com.prj.web.awesome.user.service;

import com.prj.web.awesome.user.dto.HeartDTO;
import com.prj.web.awesome.user.dto.HeartItemDTO;
import com.prj.web.awesome.user.mapperInterface.HeartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeartServiceImpl implements HeartService {

    private final HeartMapper mapper;

    @Override
    public List<HeartItemDTO> findHeartItem(String user_id) {
        return mapper.findHeartItem(user_id);
    }

    @Override
    public HeartDTO findHeart(int item_id, String user_id) {
        return mapper.findHeart(item_id, user_id);
    }

    @Override
    public void save(HeartDTO heartDTO) {
        mapper.save(heartDTO);
    }

    @Override
    public void delete(int item_id) {
        mapper.delete(item_id);
    }
}
