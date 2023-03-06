package com.prj.web.awesome.user.controller;

import com.prj.web.awesome.itemDetail.dto.ItemDetailDto;
import com.prj.web.awesome.itemDetail.service.ItemDetailService;
import com.prj.web.awesome.user.dto.HeartDTO;
import com.prj.web.awesome.user.dto.HeartItemDTO;
import com.prj.web.awesome.user.service.HeartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping(value = "/user/heart")
@RequiredArgsConstructor
@Controller
public class HeartController {

    private final HeartService hservice;

    @GetMapping
    public String showList(HttpSession session, Model model) {
        String loginID = (String) session.getAttribute("loginID");

        List<HeartItemDTO> list = hservice.findHeartItem(loginID);
        model.addAttribute("list", list);

        return "html/user/userHeart";
    }

    @ResponseBody
    @PostMapping("/{itemId}")
    public Map<String, Object> saveHeart(@PathVariable("itemId") int itemId, HeartDTO heartDTO, HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        String userId = (String) session.getAttribute("loginID");

        heartDTO.setItem_id(itemId);
        heartDTO.setUser_id(userId);
        List<Integer> heartList = (List<Integer>) session.getAttribute("heartList");

        if (heartList == null) {
            heartList = new ArrayList<Integer>();
        }

        if(userId != null) {
            if (!heartList.contains(itemId)) {
                hservice.save(heartDTO);
                heartList.add(itemId);
                session.setAttribute("heartList", heartList);

                result.put("success", true);
                result.put("message", "이 상품을 좋아합니다.");
            } else {
                result.put("success", true);
                result.put("message", "이미 좋아요 한 상품입니다.");
            }
        } else {
            result.put("success", false);
            result.put("message", "로그인 후 이용해 주세요.");
        }

        return result;
    }

    @ResponseBody
    @DeleteMapping("/{itemId}")
    public Map<String, Object> deleteHeart(@PathVariable("itemId") int itemId, HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        List<Integer> heartList = (List<Integer>) session.getAttribute("heartList");

        if (heartList.contains(itemId)) {
            hservice.delete(itemId);
            heartList.remove((Integer) itemId);
            session.setAttribute("heartList", heartList);
        }

        result.put("success", true);
        result.put("message", "이 상품을 싫어합니다!");

        return result;
    }

    @ResponseBody
    @DeleteMapping
    public Map<String, Object> deleteHearts(@RequestBody List<String> items, HttpSession session) {
        log.info("items={}", items);
        Map<String, Object> result = new HashMap<>();
        List<Integer> heartList = (List<Integer>) session.getAttribute("heartList");

        for (String itemId : items) {
            int itemIdInt = Integer.parseInt(itemId);

            if (heartList.contains(itemIdInt)) {
                hservice.delete(itemIdInt);
                heartList.remove((Integer) itemIdInt);
                result.put("success", true);
                result.put("message", "상품을 삭제하였습니다!");
            }
        }

        return result;
    }
}
