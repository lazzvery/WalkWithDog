package com.prj.web.awesome.order.controller;

import com.prj.web.admin.upload.service.ImageService;
import com.prj.web.awesome.itemDetail.dto.ItemDetailDto;
import com.prj.web.awesome.itemDetail.service.ItemDetailService;
import com.prj.web.awesome.order.dto.CouponJoinInfoDTO;
import com.prj.web.awesome.order.dto.OrderDetailItemDTO;
import com.prj.web.awesome.order.service.OrderDetailService;
import com.prj.web.awesome.user.dto.AddrDTO;
import com.prj.web.awesome.user.dto.CouponDTO;
import com.prj.web.awesome.user.dto.CouponInfoDTO;
import com.prj.web.awesome.user.dto.UserDTO;
import com.prj.web.awesome.user.service.MyPageService;
import com.prj.web.awesome.user.service.UserService;
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
@RequestMapping(value = "/order/orderDetail")
@RequiredArgsConstructor
@Controller
public class OrderDetailController {

    private final ItemDetailService iservice;
    private final UserService uservice;
    private final MyPageService mservice;
    private final OrderDetailService dservice;
    private final ImageService imgservice;

    @GetMapping
    public String orderDetail(Model model, HttpSession session, UserDTO userDTO) {
        String userId = (String) session.getAttribute("loginID");
        List<OrderDetailItemDTO> itemList = (List<OrderDetailItemDTO>) session.getAttribute("itemList");

        userDTO.setUser_id(userId);
        UserDTO user = uservice.userSelectOne(userDTO); // 유저 조회
        AddrDTO addr = mservice.findAddr(userId);  // 배송지 조회
        log.info("addr={}", addr);
        List<CouponJoinInfoDTO> couponList = dservice.findCouponList(userId);  // 쿠폰 조회

        int price = 0;
        for (OrderDetailItemDTO dto : itemList) {
            price += dto.getItem_price() * dto.getItem_amount();
        }   // 총 주문 금액

        if(price >= 50000) {
            model.addAttribute("delivery", 0);
        } else {
            model.addAttribute("delivery", 3000);
        }   // 배송비

        session.removeAttribute("orderPrice");
        session.setAttribute("orderPrice", price);

        model.addAttribute("price", price);
        model.addAttribute("user", user);
        model.addAttribute("itemList", itemList);
        model.addAttribute("addr", addr);
        model.addAttribute("couponList", couponList);

        return "html/order/orderDetail";
    }

    @ResponseBody
    @PostMapping
    public Map<String, Object> sendItems(@RequestBody List<OrderDetailItemDTO> items, HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        List<OrderDetailItemDTO> itemList = new ArrayList<>();
        log.info("items={}", items);

        if (items != null && items.size() > 0) {
            for (OrderDetailItemDTO item : items) {
                ItemDetailDto itemOne = iservice.findItem(item.getItem_id());
                String mainImg = imgservice.findMainImg(item.getItem_id());

                item.setItem_name(itemOne.getItem_name());
                item.setItem_price(itemOne.getItem_price());
                item.setImg_name(mainImg);

                itemList.add(item);
            }
        }

        session.setAttribute("itemList", itemList);

        // 로그인 하지 않은 경우 alert 창 띄우기
        if(session.getAttribute("loginID") == null) {
            result.put("success", false);
        } else {
            result.put("success", true);
        }

        return result;
    }

    @ResponseBody
    @PatchMapping
    public Map<String, Object> addCouponPrice(String selected, HttpSession session) {
        CouponInfoDTO oneCoupon = mservice.findOneCoupon(selected);
        Map<String, Object> result = new HashMap<>();
        Object orderPrice = session.getAttribute("orderPrice");

        if(oneCoupon != null) {
            result.put("orderPrice", orderPrice);
            result.put("benefits", oneCoupon.getCoupon_benefits());
        } else {
            result.put("orderPrice", orderPrice);
            result.put("benefits", 0);
        }

        return result;
    }

}