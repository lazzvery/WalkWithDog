package com.prj.web.awesome.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/user/myPage")
@Controller
public class MyPageController {

//    @GetMapping("/myHome")
//    public String myHome(Model model){
//        return "html/user/myPage/userMyPageHome";
//    }

    @GetMapping("/addr")
    public String addr(Model model){ return "html/user/myPage/userMyPageAddress"; }

    @GetMapping("/addrList")
    public String addrList(Model model){
        return "html/user/myPage/userMyPageAddrList";
    }

    @GetMapping("/register")
    public String register(Model model){ return "html/user/myPage/userMyPageRegister"; }

    @GetMapping("/coupon")
    public String coupon(Model model){ return "html/user/myPage/userMyPageCoupon"; }

//    @GetMapping("/modify")
//    public String modify(Model model){ return "html/user/myPage/userMyPageModify"; }

    @GetMapping("/order")
    public String order(Model model){ return "html/user/myPage/userMyPageOrder"; }






}
