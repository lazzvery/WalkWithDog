package com.prj.web.awesome.order.controller;

import com.prj.web.awesome.order.dto.OrderDetailDTO;
import com.prj.web.awesome.order.dto.OrderDetailItemDTO;
import com.prj.web.awesome.order.dto.OrderListDTO;
import com.prj.web.awesome.order.service.OrderDetailService;
import com.prj.web.awesome.order.service.OrderListService;
import com.prj.web.awesome.user.dto.AddrDTO;
import com.prj.web.awesome.user.dto.UserDTO;
import com.prj.web.awesome.user.service.CartService;
import com.prj.web.awesome.user.service.MyPageService;
import com.prj.web.awesome.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping
@RequiredArgsConstructor
@RestController
public class OrderListController {

    private final UserService uservice;
    private final MyPageService mservice;
    private final OrderListService lservice;
    private final OrderDetailService dservice;
    private final CartService cservice;

    @PostMapping("/payment/proceed")
    public Map<String, Object> sendOrderInfo(String coupon, String price, HttpSession session, UserDTO userDTO, OrderListDTO orderListDTO) {
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

        OrderListDTO orderList = findOrder(orderListDTO);

        result.put("userDTO", user);
        result.put("addrDTO", addr);
        result.put("price", price);
        result.put("orderCode", orderList.getOrder_code());

        return result;
    }

    @PostMapping("/payment/succeed")
    public Map<String, Object> successOrder(String merchant_uid, HttpSession session, OrderDetailDTO orderDetailDTO) {
        List<OrderDetailItemDTO> itemList = (List<OrderDetailItemDTO>) session.getAttribute("itemList");
        Map<String, Object> result = new HashMap<>();

        OrderListDTO orderList = dservice.findOrderList(Integer.parseInt(merchant_uid));  // 주문 리스트 조회
        lservice.updateStatus(Integer.parseInt(merchant_uid));  // 주문 상태 업데이트

        for (OrderDetailItemDTO dto : itemList) {
            cservice.deleteCart(dto.getItem_id());  // 장바구니 삭제

            orderDetailDTO.setOrder_code(Integer.parseInt(merchant_uid));
            orderDetailDTO.setItem_id(dto.getItem_id());
            orderDetailDTO.setItem_price(dto.getItem_price());
            orderDetailDTO.setItem_count(dto.getItem_amount());
            dservice.saveCart(orderDetailDTO);  // 주문 상세 테이블 생성
        }

        String couponCode = orderList.getCoupon_code();
        if(couponCode != null) {
            mservice.updateCouponQuantity(couponCode);
        }   // 쿠폰 수량 -1

        session.removeAttribute("itemList"); // 임시 주문 목록 삭제

        return result;
    }

    @Transactional
    public OrderListDTO findOrder(OrderListDTO orderListDTO) {
        lservice.createOrderList(orderListDTO); // 주문 테이블 생성
        OrderListDTO byDTO = lservice.findById();
        return byDTO;
    }   // method

}
