package com.prj.web.awesome.order.service;

import com.prj.web.awesome.order.dto.OrderListDTO;
import com.prj.web.awesome.order.mapper.OrderListMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderListServiceImpl implements OrderListService {

    private final OrderListMapper orderListMapper;

    @Override
    public OrderListDTO findById(int order_code) {
        return orderListMapper.findById(order_code);
    }

    @Override
    public void createOrderList(String user_id) {
        orderListMapper.createOrderList(user_id);
    }
}
