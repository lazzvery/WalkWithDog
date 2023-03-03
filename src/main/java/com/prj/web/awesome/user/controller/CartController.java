package com.prj.web.awesome.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequestMapping(value = "/user")
@Controller
public class CartController {

    @GetMapping("/cart")
    public String cart(HttpSession session){
        session.invalidate();
        return "html/user/userCart";
    }
}
