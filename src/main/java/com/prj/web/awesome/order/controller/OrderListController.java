package com.prj.web.awesome.order.controller;

import com.prj.web.awesome.order.dto.OrderListDTO;
import com.prj.web.awesome.order.service.OrderDetailService;
import com.prj.web.awesome.order.service.OrderListService;
import com.prj.web.awesome.user.dto.AddrDTO;
import com.prj.web.awesome.user.dto.UserDTO;
import com.prj.web.awesome.user.service.MyPageService;
import com.prj.web.awesome.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequestMapping
@RequiredArgsConstructor
@RestController
public class OrderListController {

    private final UserService uservice;
    private final MyPageService mservice;
    private final OrderDetailService dservice;
    private final OrderListService lservice;

    @PostMapping("/payment/proceed")
    public Map<String, Object> sendItems(String coupon, String price, HttpSession session, UserDTO userDTO, OrderListDTO orderListDTO) {
        String userId = (String) session.getAttribute("loginID");
        Map<String, Object> result = new HashMap<>();

        userDTO.setUser_id(userId);
        UserDTO user = uservice.userSelectOne(userDTO); // 유저 조회
        AddrDTO addr = mservice.findAddr(userId);   // 주소 조회

        orderListDTO.setOrder_price(Integer.parseInt(price));
        orderListDTO.setOrder_payment("card");
        orderListDTO.setUser_id(userId);
        if(!coupon.equals("0")) orderListDTO.setCoupon_code(coupon);
        orderListDTO.setAddr_seq(addr.getAddr_seq());

        OrderListDTO orderList = findOrder(orderListDTO);   // 주문 테이블 seq

        result.put("userDTO", user);
        result.put("addrDTO", addr);
        result.put("price", price);
        result.put("orderSeq", orderList.getOrder_code());

        return result;
    }

    @Transactional
    public OrderListDTO findOrder(OrderListDTO orderListDTO) {
        lservice.createOrderList(orderListDTO);
        OrderListDTO byDTO = lservice.findById();

        return byDTO;
    }

}
