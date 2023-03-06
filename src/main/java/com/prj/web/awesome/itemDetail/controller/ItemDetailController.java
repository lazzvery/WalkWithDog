package com.prj.web.awesome.itemDetail.controller;

import com.prj.web.awesome.item.cri.CriteriaQna;
import com.prj.web.awesome.item.cri.PageNationQna;
import com.prj.web.awesome.item.dto.ItemQnaDTO;
import com.prj.web.awesome.item.service.ItemQnaService;
import com.prj.web.awesome.itemDetail.dto.ItemDetailDto;
import com.prj.web.awesome.itemDetail.service.ItemDetailService;
import com.prj.web.awesome.user.service.HeartService;
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
    private final HeartService hservice;

    @GetMapping("/{itemId}")
    public String searchItem(@PathVariable("itemId") int itemId,
                             @RequestParam(defaultValue = "1") int currPage,
                             Model model, HttpSession session){

        CriteriaQna criteriaQna = new CriteriaQna(5, currPage);
        PageNationQna pageNationQna = new PageNationQna(criteriaQna);
        criteriaQna.setTotalCount(qservice.criTotalCount(itemId));
        criteriaQna.setItem_id(itemId);
        pageNationQna.calc();   // 게시판 페이징

        ItemDetailDto item = dservice.findItem(itemId); // 아이템 조회
        List<ItemQnaDTO> qna = qservice.criList(criteriaQna);   // 게시판 조회

        String userId = (String) session.getAttribute("loginID");
        if(hservice.findHeart(itemId, userId) != null) {
            model.addAttribute("checkHeart", true);
        } else {
            model.addAttribute("checkHeart", false);
        }   // 좋아요 누른 상품인지 아닌지 구분

        model.addAttribute("loginID", userId);
        model.addAttribute("item", item);
        model.addAttribute("qna", qna);
        model.addAttribute("page", pageNationQna);
        model.addAttribute("cri", criteriaQna);

        return "html/item/itemDetail";

    }

    @ResponseBody
    @PostMapping("/{itemId}")
    public Map<String, Object> insertQna(@PathVariable("itemId") int itemId, ItemQnaDTO itemQnaDTO, HttpSession session) {

        String userId = (String) session.getAttribute("loginID");

        Map<String, Object> result = new HashMap<>();
        if(userId != null) {
            itemQnaDTO.setUser_id(userId);  // 답글이면 세션에 있는 아이디 대신 부모 글의 아이디 넣는 작업 필요
            qservice.save(itemQnaDTO);
            result.put("success", true);
            result.put("message", "질문이 등록되었습니다.");
        } else {
            result.put("success", false);
            result.put("message", "로그인 후 이용 가능합니다.");
        }

        return result;
    }

    @ResponseBody
    @PatchMapping("/{itemId}")
    public Map<String, Object> updateQna(@PathVariable("itemId") int itemId, ItemQnaDTO itemQnaDTO) {

        qservice.update(itemQnaDTO);

        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "질문이 수정되었습니다.");

        return result;

    }

    @ResponseBody
    @DeleteMapping("/{itemId}")
    public Map<String, Object> deleteQna(@PathVariable("itemId") int itemId, int itemQnaSeq) {

        qservice.delete(itemQnaSeq);

        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "삭제되었습니다!");

        return result;

    }

}