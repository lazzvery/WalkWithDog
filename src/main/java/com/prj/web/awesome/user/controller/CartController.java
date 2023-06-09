package com.prj.web.awesome.user.controller;

import com.prj.web.awesome.itemDetail.service.ItemDetailService;
import com.prj.web.awesome.user.dto.CartDTO;
import com.prj.web.awesome.user.dto.CartItemDTO;
import com.prj.web.awesome.user.service.CartService;
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
@RequestMapping(value = "/user/cart")
@RequiredArgsConstructor
@Controller
public class CartController {

    private final CartService cservice;
    private final ItemDetailService iservice;

    @GetMapping
    public String cart(HttpSession session, Model model) {
        String loginID = (String) session.getAttribute("loginID");
        List<CartItemDTO> cartItem = cservice.findCartItem(loginID);    // 장바구니 조회

        int price = 0;
        for (CartItemDTO cartItemDTO : cartItem) {
            price += cartItemDTO.getItem_price() * cartItemDTO.getCart_amount();
        }   // 주문 금액

        if(price >= 50000) {
            model.addAttribute("delivery", 0);
        } else {
            model.addAttribute("delivery", 3000);
        }   // 배송비

        model.addAttribute("cartItem", cartItem);
        model.addAttribute("price", price);

        return "html/user/userCart";
    }

    @ResponseBody
    @PostMapping("/calcPrice")
    public Map<String, Object> calcPrice(@RequestBody List<Map<String, Object>> items) {
        Map<String, Object> result = new HashMap<>();

        int price = 0;
        for (Map<String, Object> item : items) {
            int itemId = Integer.parseInt((String) item.get("item_id"));
            int itemAmount = Integer.parseInt((String) item.get("item_amount"));
            int itemPrice = iservice.findItem(itemId).getItem_price();

            price += itemPrice * itemAmount;
        }   // 주문 금액

        if(price >= 50000) {
            result.put("delivery", 0);
        } else {
            result.put("delivery", 3000);
        }   // 배송비

        result.put("price", price);
        return result;
    }

    @ResponseBody
    @PostMapping("/{itemId}")
    public Map<String, Object> saveCart(@PathVariable("itemId") int itemId, int selected, CartDTO cartDTO, HttpSession session) {
        String userId = (String) session.getAttribute("loginID");
        Map<String, Object> result = new HashMap<>();

        cartDTO.setUser_id(userId);
        cartDTO.setItem_id(itemId);
        cartDTO.setCart_amount(selected);   // 값 저장

        List<CartItemDTO> cartItem = cservice.findCartItem(userId);

        if(cartItem.size() >= 10) {
            result.put("success", true);
            result.put("message", "장바구니는 10개까지 등록 가능합니다.");
            return result;
        }

        if (userId != null) {
            if (cservice.findCart(itemId, userId) == null) {
                cservice.saveCart(cartDTO);
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

        return result;
    }

    @ResponseBody
    @PostMapping
    public Map<String, Object> saveCarts(@RequestBody List<String> items, HttpSession session) {
        String userId = (String) session.getAttribute("loginID");
        List<CartItemDTO> cartItem = cservice.findCartItem(userId);
        Map<String, Object> result = new HashMap<>();

        if((items.size() + cartItem.size()) >= 10) {
            result.put("success", true);
            result.put("message", "장바구니는 10개까지 등록 가능합니다.");
            return result;
        }

        if (items != null && items.size() > 0) {    // 좋아요 -> 장바구니 저장
            for (String itemId : items) {

                CartDTO cartDTO = new CartDTO();
                cartDTO.setItem_id(Integer.parseInt(itemId));
                cartDTO.setUser_id(userId);
                cartDTO.setCart_amount(1);

                if (cservice.findCart(Integer.valueOf(itemId), userId) == null) {
                    cservice.saveCart(cartDTO);
                    result.put("success", true);
                    result.put("message", "장바구니에 상품을 담았습니다. \n장바구니로 이동하시겠습니까?");
                } else {
                    result.put("success", true);
                    result.put("message", "이미 담은 상품을 제외하고 장바구니에 담았습니다. \n장바구니로 이동하시겠습니까?");
                }

            }
        } else {
            result.put("success", false);
            result.put("message", "담을 상품을 선택해 주세요.");
        }

        return result;
    }

    @ResponseBody
    @DeleteMapping("/{itemId}")
    public Map<String, Object> deleteCart(@PathVariable("itemId") int itemId, HttpSession session) {
        String userId = (String) session.getAttribute("loginID");
        Map<String, Object> result = new HashMap<>();

        if (cservice.findCart(itemId, userId) != null) {
            cservice.deleteCart(itemId);
        }

        result.put("success", true);
        result.put("message", "장바구니에서 삭제하였습니다.");

        return result;
    }

    @ResponseBody
    @DeleteMapping
    public Map<String, Object> deleteCarts(@RequestBody List<String> items, HttpSession session) {
        String userId = (String) session.getAttribute("loginID");
        Map<String, Object> result = new HashMap<>();

        for (String itemId : items) {
            int itemIdInt = Integer.parseInt(itemId);

            if (cservice.findCart(Integer.valueOf(itemId), userId) != null) {
                cservice.deleteCart(itemIdInt);
                result.put("success", true);
                result.put("message", "상품을 삭제하였습니다!");
            }
        }

        return result;
    }
}
