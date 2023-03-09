package com.prj.web.awesome.order.service;

import com.prj.web.awesome.order.dto.CouponJoinInfoDTO;
import com.prj.web.awesome.order.dto.OrderDetailDTO;
import com.prj.web.awesome.order.dto.OrderDetailItemDTO;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetailItemDTO> findOrderList(int order_code);
    void saveCart(OrderDetailDTO orderDetailDTO);
    List<CouponJoinInfoDTO> findCouponList(String user_id);
}
