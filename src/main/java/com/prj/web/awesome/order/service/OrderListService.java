package com.prj.web.awesome.order.service;

import com.prj.web.awesome.order.dto.OrderListDTO;

public interface OrderListService {
    OrderListDTO findById();
    void createOrderList(OrderListDTO orderListDTO);
    void updateStatus(int order_code);
}
