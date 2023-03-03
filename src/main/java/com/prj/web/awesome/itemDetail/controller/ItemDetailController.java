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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @ResponseBody
    public Map<String, Object> insertQna(@PathVariable("itemId") int itemId, ItemQnaDTO itemQnaDTO, HttpSession session) {
        String userId = (String) session.getAttribute("loginID");

        itemQnaDTO.setUser_id(userId);
        qservice.save(itemQnaDTO);

        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "질문이 성공적으로 등록되었습니다.");

        return result;
    }

}