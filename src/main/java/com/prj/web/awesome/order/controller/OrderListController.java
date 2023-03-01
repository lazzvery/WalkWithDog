package com.prj.web.awesome.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class OrderListController {
    @GetMapping("/itemDetail")
    public String cart(){
        return "html/item/itemDetail";
    }
}
