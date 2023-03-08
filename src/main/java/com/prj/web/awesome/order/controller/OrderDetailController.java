package com.prj.web.awesome.order.controller;

import com.prj.web.awesome.itemDetail.dto.ItemDetailDto;
import com.prj.web.awesome.itemDetail.service.ItemDetailService;
import com.prj.web.awesome.order.dto.ItemSendDTO;
import com.prj.web.awesome.order.dto.OrderDetailDTO;
import com.prj.web.awesome.order.dto.OrderDetailItemDTO;
import com.prj.web.awesome.order.service.OrderDetailService;
import com.prj.web.awesome.order.service.OrderListService;
import com.prj.web.awesome.user.dto.AddrDTO;
import com.prj.web.awesome.user.dto.UserDTO;
import com.prj.web.awesome.user.service.MyPageService;
import com.prj.web.awesome.user.service.UserService;
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
@RequestMapping(value = "/order/orderDetail")
@RequiredArgsConstructor
@Controller
public class OrderDetailController {

    private final OrderListService lservice;
    private final OrderDetailService dService;
    private final ItemDetailService iservice;
    private final UserService uservice;
    private final MyPageService mservice;

    @GetMapping
    public String orderDetail(Model model, int orderCode, HttpSession session, UserDTO userDTO) {
        String userId = (String) session.getAttribute("loginID");
        userDTO.setUser_id(userId);

        List<OrderDetailItemDTO> orderList = dService.findOrderList(orderCode); // 주문 상세 조회
        UserDTO user = uservice.userSelectOne(userDTO); // 유저 조회

        model.addAttribute("user", user);
        model.addAttribute("orderList", orderList);

        return "html/order/orderDetail";
    }

    @ResponseBody
    @PostMapping
    public Map<String, Object> sendItems(@RequestBody List<ItemSendDTO> items, HttpSession session, OrderDetailDTO orderDetailDTO) {
        Map<String, Object> result = new HashMap<>();
        String userId = (String) session.getAttribute("loginID");

        lservice.createOrderList(userId);

        if (items != null && items.size() > 0) {
            for (ItemSendDTO item : items) {
                ItemDetailDto itemOne = iservice.findItem(item.getItem_id());

                orderDetailDTO.setItem_id(item.getItem_id());
                orderDetailDTO.setItem_count(item.getItem_amount());
                orderDetailDTO.setItem_price(itemOne.getItem_price());

                dService.saveCart(orderDetailDTO);
            }
        }

        result.put("orderCode", orderDetailDTO.getOrder_code());
        result.put("success", true);
        result.put("message", "저장됐다!!");

        return result;
    }

}