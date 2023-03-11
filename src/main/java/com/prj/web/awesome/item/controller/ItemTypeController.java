package com.prj.web.awesome.item.controller;

import com.prj.web.awesome.category.dto.CategoryDTO;
import com.prj.web.awesome.category.service.CategoryService;
import com.prj.web.awesome.community.dto.NoticeDTO;
import com.prj.web.awesome.item.dto.ItemDto;
import com.prj.web.awesome.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/item/list2")
@Controller
public class ItemTypeController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String searchCategory(String ctgr_cd, Model model) {

        List<ItemDto> itemDto = itemService.itemList(ctgr_cd);
        List<CategoryDTO> categoryDTO = categoryService.searchCtgr("0001");

        model.addAttribute("ctgr_cd", ctgr_cd);
        model.addAttribute("itemDto", itemDto);
        model.addAttribute("categoryDto", categoryDTO);
        System.out.println(categoryDTO);

        return "html/itemList/itemList";
    }



    @GetMapping("/itemBest")
    public String itemBest(String item_best, Model model){

        List<ItemDto> itemDto = itemService.itemList(item_best);

        model.addAttribute("itemDto", itemDto);

        return "html/itemList/itemBest";

    }
}
