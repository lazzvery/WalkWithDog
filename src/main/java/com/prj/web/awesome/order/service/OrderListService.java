package com.prj.web.awesome.order.service;

import com.prj.web.awesome.order.dto.OrderListDTO;

public interface OrderListService {
    OrderListDTO findById(int order_code);
    void createOrderList(String user_id);
}
