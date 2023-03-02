package com.prj.web.awesome.itemDetail.controller;

import com.prj.web.awesome.item.dto.ItemQnaDTO;
import com.prj.web.awesome.item.service.ItemQnaService;
import com.prj.web.awesome.itemDetail.dto.ItemDetailDto;
import com.prj.web.awesome.itemDetail.service.ItemDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/item/itemDetail")
public class ItemDetailController {

    private final ItemDetailService dservice;
    private final ItemQnaService qservice;

    @GetMapping
    public String searchItem(int item_id, Model model){
        ItemDetailDto item = dservice.findItem(item_id);
        List<ItemQnaDTO> qna = qservice.findAll(item_id);

        model.addAttribute("item", item);
        model.addAttribute("qna", qna);

        log.info("item_id={}", item_id);
        log.info("item={}", item);
        log.info("qna={}", qna);

        return "html/item/itemDetail";
    }

}
