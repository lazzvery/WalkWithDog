package com.prj.web.awesome.item.controller;

import com.prj.web.awesome.item.dto.ItemDto;
import com.prj.web.awesome.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/item/list")
@Controller
public class ItemTypeController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/new")
    public String listNew(Model model, ItemDto itemDto){

        List<ItemDto> listNew = itemService.itemList(itemDto.getCtgr_cd());

        model.addAttribute("listNew", listNew);

        return "html/itemList/new";
    }


    @GetMapping("/living")
    public String listLiving(Model model, ItemDto itemDto){

        List<ItemDto> listLiving = itemService.itemList(itemDto.getCtgr_cd());

        model.addAttribute("listLiving", listLiving);

        return "html/itemList/living";
    }


    @GetMapping("/working")
    public String listWorking(Model model, ItemDto itemDto){

        List<ItemDto> listWorking = itemService.itemList(itemDto.getCtgr_cd());

        model.addAttribute("listWorking", listWorking);

        return "html/itemList/working";
    }


    @GetMapping("/food")
    public String listFood(Model model, ItemDto itemDto){

        List<ItemDto> listFood = itemService.itemList(itemDto.getCtgr_cd());

        model.addAttribute("listFood", listFood);

        return "html/itemList/food";
    }


    @GetMapping("/clean")
    public String listClean(Model model, ItemDto itemDto){

        List<ItemDto> listClean = itemService.itemList(itemDto.getCtgr_cd());

        model.addAttribute("listClean", listClean);

        return "html/itemList/clean";
    }


    @GetMapping("/forcat")
    public String listForCat(Model model, ItemDto itemDto){

        List<ItemDto> listForCat = itemService.itemList(itemDto.getCtgr_cd());

        model.addAttribute("listForCat", listForCat);

        return "html/itemList/forcat";
    }



}
