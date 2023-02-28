package com.prj.web.awesome.item.service;

import com.prj.web.awesome.item.dto.ItemDTO;
import com.prj.web.awesome.item.mapper.ItemMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemMapper mapper;

    public List<ItemDTO> itemList(String ctgr_cd) {
        return mapper.itemList(ctgr_cd);
    }
}
