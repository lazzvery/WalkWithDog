package com.prj.web.awesome.item.controller;

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

    @GetMapping
    public String searchCategory(String ctgr_cd, Model model) {

//        System.out.println(ctgr_cd);

        List<ItemDto> itemDto = itemService.itemList(ctgr_cd);
        model.addAttribute("itemDto", itemDto);
        System.out.println(itemDto);

        return "html/itemList/itemList";
    }
//    @GetMapping("/new")
//    public String newList (Model model, ItemDto itemDto){
//
//        List<ItemDto> newList = itemService.itemList(itemDto.getCtgr_cd());
//
//        model.addAttribute("newList", newList);
//
//        return "html/itemList/new";
//    }
//
//
//    @GetMapping("/living")
//    public String living(Model model, ItemDto itemDto){
//
//        List<ItemDto> living = itemService.itemList(itemDto.getCtgr_cd());
//
//        model.addAttribute("living", living);
//
//        return "html/itemList/living";
//    }
//
//
//    @GetMapping("/working")
//    public String working(Model model, ItemDto itemDto){
//
//        List<ItemDto> working = itemService.itemList(itemDto.getCtgr_cd());
//
//        model.addAttribute("working", working);
//
//        return "html/itemList/working";
//    }
//
//
//    @GetMapping("/food")
//    public String food(Model model, ItemDto itemDto){
//
//        List<ItemDto> food = itemService.itemList(itemDto.getCtgr_cd());
//
//        model.addAttribute("food", food);
//
//        return "html/itemList/food";
//    }
//
//
//    @GetMapping("/clean")
//    public String clean(Model model, ItemDto itemDto){
//
//        List<ItemDto> clean = itemService.itemList(itemDto.getCtgr_cd());
//
//        model.addAttribute("clean", clean);
//
//        return "html/itemList/clean";
//    }
//
//
//    @GetMapping("/forcat")
//    public String forcat(Model model, ItemDto itemDto){
//
//        List<ItemDto> forcat = itemService.itemList(itemDto.getCtgr_cd());
//
//        model.addAttribute("forcat", forcat);
//
//        return "html/itemList/forcat";
//    }



}
