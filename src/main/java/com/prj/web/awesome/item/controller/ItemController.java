package com.prj.web.awesome.item.controller;

import com.prj.web.awesome.item.dto.ItemDTO;
import com.prj.web.awesome.item.payload.in.dto.ItemInDto;
import com.prj.web.awesome.item.payload.out.dto.ItemOutDto;
import com.prj.web.awesome.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    public List<ItemOutDto> itemList(ItemInDto inDto) {
        List<ItemDTO> itemArr = itemService.itemList(inDto.getCtgr_cd());

        List<ItemOutDto> itemOutArr = new ArrayList<>();

        for (ItemDTO item:itemArr) {
            ItemOutDto outDto = new ItemOutDto();

            outDto.setItem_id(item.getItem_id());
            outDto.setCtgr_cd(item.getCtgr_cd());
            outDto.setItem_name(item.getItem_name());
            outDto.setItem_price(item.getItem_price());
            outDto.setItem_amount(item.getItem_amount());
            outDto.setItem_reg_date(item.getItem_reg_date());
            outDto.setItem_data_del_yn(item.getItem_data_del_yn());

            itemOutArr.add(outDto);
        }
        return itemOutArr;
    }
}
