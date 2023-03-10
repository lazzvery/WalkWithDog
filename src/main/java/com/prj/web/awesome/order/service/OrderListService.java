package com.prj.web.awesome.order.service;

import com.prj.web.awesome.order.dto.OrderListDTO;

public interface OrderListService {
    OrderListDTO findById();
    void createOrderList(OrderListDTO orderListDTO);
}
