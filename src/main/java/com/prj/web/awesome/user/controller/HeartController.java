package com.prj.web.awesome.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/user")
@Controller
public class HeartController {

    @GetMapping("/heart")
    public String heart(){
        return "html/user/userHeart";
    }
}
