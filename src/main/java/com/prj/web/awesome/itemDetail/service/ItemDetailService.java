package com.prj.web.awesome.itemDetail.service;

import com.prj.web.awesome.item.dto.ItemDto;
import com.prj.web.awesome.item.dto.ItemQnaDTO;
import com.prj.web.awesome.item.mapper.ItemMapper;
import com.prj.web.awesome.itemDetail.dto.ItemDetailDto;
import com.prj.web.awesome.itemDetail.mapper.ItemDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemDetailService {

    private final ItemDetailMapper mapper;

    public ItemDetailDto findItem(int item_id) {
        return mapper.findItem(item_id);
    }

}
