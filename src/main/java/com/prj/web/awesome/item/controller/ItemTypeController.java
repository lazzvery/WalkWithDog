package com.prj.web.awesome.item.controller;

import com.prj.web.awesome.community.dto.NoticeDTO;
import com.prj.web.awesome.item.dto.ItemDto;
import com.prj.web.awesome.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/item/list")
@Controller
public class ItemTypeController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/new")
    public String itemList(Model model, ItemDto itemDto){

        List<ItemDto> itemList = itemService.itemList(itemDto.getCtgr_cd());

        model.addAttribute("itemList", itemList);

        return "html/itemList/itemList";
    }
}
