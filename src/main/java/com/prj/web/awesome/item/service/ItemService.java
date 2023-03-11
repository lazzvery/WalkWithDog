package com.prj.web.awesome.item.service;

import com.prj.web.awesome.community.dto.NoticeDTO;
import com.prj.web.awesome.item.dto.ItemDto;
import com.prj.web.awesome.item.mapper.ItemMapper;
import com.prj.web.awesome.item.payload.out.dto.ItemOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemMapper mapper;

    public List<ItemDto> itemList(String ctgr_cd) {
        return mapper.itemList(ctgr_cd);
    }

    public List<ItemDto> itemBest(String item_best) {

        return mapper.itemBest(item_best);
    }
}
