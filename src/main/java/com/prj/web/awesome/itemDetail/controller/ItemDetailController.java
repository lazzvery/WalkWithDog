package com.prj.web.awesome.itemDetail.controller;

import com.prj.web.awesome.item.dto.ItemQnaDTO;
import com.prj.web.awesome.item.service.ItemQnaService;
import com.prj.web.awesome.itemDetail.dto.ItemDetailDto;
import com.prj.web.awesome.itemDetail.service.ItemDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

        return "html/item/itemDetail";
    }

    @PostMapping
    public String insertQna(ItemQnaDTO itemQnaDTO, HttpSession session) {
        String userId = (String) session.getAttribute("loginID");

        itemQnaDTO.setUser_id(userId);
        itemQnaDTO.setItem_qna_pnum(itemQnaDTO.getItem_qna_pnum());
        qservice.save(itemQnaDTO);

        return "redirect:/item/itemDetail?item_id=" + itemQnaDTO.getItem_id();
    }

}