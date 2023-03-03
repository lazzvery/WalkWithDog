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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/item/itemDetail")
public class ItemDetailController {

    private final ItemDetailService dservice;
    private final ItemQnaService qservice;

    @GetMapping("/{itemId}")
    public String searchItem(@PathVariable("itemId") int itemId, Model model){
        ItemDetailDto item = dservice.findItem(itemId);
        List<ItemQnaDTO> qna = qservice.findAll(itemId);

        model.addAttribute("item", item);
        model.addAttribute("qna", qna);

        return "html/item/itemDetail";
    }

    @PostMapping("/{itemId}")
    public String insertQna(@PathVariable("itemId") int itemId, ItemQnaDTO itemQnaDTO, HttpSession session, RedirectAttributes rttr) {
        String userId = (String) session.getAttribute("loginID");

        itemQnaDTO.setUser_id(userId);
        itemQnaDTO.setItem_qna_pnum(itemQnaDTO.getItem_qna_pnum());
        qservice.save(itemQnaDTO);

        rttr.addAttribute("itemId", itemQnaDTO.getItem_id());
        log.info("itemId={}", itemQnaDTO.getItem_id());

        return "redirect:/item/itemDetail/{itemId}";
    }

}