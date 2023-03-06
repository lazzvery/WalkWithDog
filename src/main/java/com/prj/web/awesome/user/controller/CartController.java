package com.prj.web.awesome.user.controller;

import com.prj.web.awesome.user.dto.CartDTO;
import com.prj.web.awesome.user.dto.CartItemDTO;
import com.prj.web.awesome.user.service.CartService;
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
@RequestMapping(value = "/user/cart")
@RequiredArgsConstructor
@Controller
public class CartController {

    private final CartService cservice;

    @GetMapping
    public String cart(HttpSession session, Model model){
        String loginID = (String) session.getAttribute("loginID");

        List<CartItemDTO> cartItem = cservice.findCartItem(loginID);
        model.addAttribute("cartItem", cartItem);
        log.info("cartItem={}", cartItem);

        return "html/user/userCart";
    }

    @ResponseBody
    @PostMapping("/{itemId}")
    public Map<String, Object> saveHeart(@PathVariable("itemId") int itemId, int selected, CartDTO cartDTO, HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        String userId = (String) session.getAttribute("loginID");

        cartDTO.setUser_id(userId);
        cartDTO.setItem_id(itemId);
        cartDTO.setCart_amount(selected);
        log.info("selected={}", selected);
        List<Integer> cartList = (List<Integer>) session.getAttribute("cartList");

        if (cartList == null) {
            cartList = new ArrayList<Integer>();
        }

        if(userId != null) {
            if (!cartList.contains(itemId)) {
                cservice.saveCart(cartDTO);
                cartList.add(itemId);
                session.setAttribute("cartList", cartList);

                result.put("success", true);
                result.put("message", "장바구니에 상품을 담았습니다.");
            } else {
                result.put("success", true);
                result.put("message", "이미 담은 상품입니다.");
            }
        } else {
            result.put("success", false);
            result.put("message", "로그인 후 이용해 주세요!");
        }
        log.info("cartList={}", cartList);

        return result;
    }

    @ResponseBody
    @DeleteMapping("/{itemId}")
    public Map<String, Object> deleteCart(@PathVariable("itemId") int itemId, HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        List<Integer> cartList = (List<Integer>) session.getAttribute("cartList");
        log.info("cartList={}", cartList);

        if (cartList.contains(itemId)) {
            cservice.deleteCart(itemId);
            cartList.remove((Integer) itemId);
            session.setAttribute("cartList", cartList);
        }

        result.put("success", true);
        result.put("message", "장바구니에서 삭제하였습니다.");

        return result;
    }

    @ResponseBody
    @DeleteMapping
    public Map<String, Object> deleteCarts(@RequestBody List<String> items, HttpSession session) {
        log.info("items={}", items);
        Map<String, Object> result = new HashMap<>();
        List<Integer> cartList = (List<Integer>) session.getAttribute("cartList");

        for (String itemId : items) {
            int itemIdInt = Integer.parseInt(itemId);

            if (cartList.contains(itemIdInt)) {
                cservice.deleteCart(itemIdInt);
                cartList.remove((Integer) itemIdInt);
                result.put("success", true);
                result.put("message", "상품을 삭제하였습니다!");
            }
        }

        return result;
    }
}
