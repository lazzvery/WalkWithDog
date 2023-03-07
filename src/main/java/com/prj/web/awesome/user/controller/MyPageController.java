package com.prj.web.awesome.user.controller;

import com.prj.web.awesome.user.dto.AddrDTO;
import com.prj.web.awesome.user.service.MyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/user/myPage")
@Controller
public class MyPageController {

    @Autowired
    MyPageService service;

//    @GetMapping("/myHome")
//    public String myHome(Model model){
//        return "html/user/myPage/userMyPageHome";
//    }

    @GetMapping("/addr")
    public String addr(Model model){ return "html/user/myPage/userMyPageAddress"; }


    @GetMapping("/addrList")
    public String addrList(Model model, AddrDTO dto, HttpServletRequest request) {
        dto.setUser_id((String)request.getSession().getAttribute("loginID"));

        dto=service.addrList(dto);

        model.addAttribute("addrList", dto);



        return "html/user/myPage/userMyPageAddrList";
    } //ulist

    //  배송지추가
    @GetMapping("/addrInsert")
    public String addrInsertForm(){
        return "/html/user/myPage/userMyPageAddrInsert";
    }

    @PostMapping("/addrInsert")
    public String addrInsert( AddrDTO dto, HttpServletRequest request){
        dto.setUser_id((String)request.getSession().getAttribute("loginID"));


        AddrDTO addrInfo = new AddrDTO();
        addrInfo.setAddr_seq(dto.getAddr_seq());
        addrInfo.setAddr_name(dto.getAddr_name());
        addrInfo.setAddr_reciver(dto.getAddr_reciver());
        addrInfo.setAddr_postcode(dto.getAddr_postcode());
        addrInfo.setAddr_addr(dto.getAddr_addr());
        addrInfo.setAddr_addr2(dto.getAddr_addr2());
        addrInfo.setAddr_phone(dto.getAddr_phone());
        addrInfo.setAddr_default(dto.getAddr_default());

        addrInfo.setUser_id(dto.getUser_id());


        service.addrInsert(addrInfo);

        return "redirect:/user/myPage/addrList";
    }

    @GetMapping("/register")
    public String register(Model model){ return "html/user/myPage/userMyPageRegister"; }

    @GetMapping("/coupon")
    public String coupon(Model model){ return "html/user/myPage/userMyPageCoupon"; }

    @GetMapping("/order")
    public String order(Model model){ return "html/user/myPage/userMyPageOrder"; }






}
