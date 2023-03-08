package com.prj.web.admin.item.service;


import com.prj.web.admin.item.mapperInterface.AdminItemMapper;
import com.prj.web.awesome.item.dto.ItemDto;
import com.prj.web.awesome.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminItemService {

    @Autowired
    private final AdminItemMapper mapper;

    public List<ItemDto> itemList(){
        List<ItemDto> itemList = new ArrayList<ItemDto>();

        try {
            itemList = mapper.itemList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return itemList;
    }

}
