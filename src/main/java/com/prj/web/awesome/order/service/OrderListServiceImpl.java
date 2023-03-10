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
    public OrderListDTO findById() {
        return orderListMapper.findById();
    }

    @Override
    public void createOrderList(OrderListDTO orderListDTO) {
       orderListMapper.createOrderList(orderListDTO);
    }

    @Override
    public void updateStatus(int order_code) {
        orderListMapper.updateStatus(order_code);
    }
}
