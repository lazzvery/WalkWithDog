package com.prj.web.awesome.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/order")
@Controller
public class OrderDetailController {

    @GetMapping("/orderDetail")
    public String orderDetail(){
        return "html/order/orderDetail";
    }

}