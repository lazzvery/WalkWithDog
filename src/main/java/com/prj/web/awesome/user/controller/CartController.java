package com.prj.web.awesome.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/user")
@Controller
public class CartController {

    @GetMapping("/cart")
    public String cart(){
        return "html/user/userCart";
    }
}
