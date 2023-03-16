package com.prj.web.admin.user.controller;

import com.prj.web.admin.user.service.AdminMyPageService;
import com.prj.web.awesome.community.criTest.SearchCriteria;
import com.prj.web.awesome.order.dto.CouponJoinInfoDTO;
import com.prj.web.awesome.order.service.OrderDetailService;
import com.prj.web.awesome.user.dto.AddrDTO;
import com.prj.web.awesome.user.dto.CouponDTO;
import com.prj.web.awesome.user.dto.UserDTO;
import com.prj.web.awesome.user.service.MyPageService;
import com.prj.web.awesome.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminUserController {

    @Autowired
    UserService service;
    @Autowired
    MyPageService mservice;
    @Autowired
    AdminMyPageService aservice;
    @Autowired
    OrderDetailService dservice;

    // 유저 리스트
    @GetMapping("/user/userInfo")
    public String ulist(Model model) {

        List<UserDTO> selectList = service.selectList();

        model.addAttribute("selectList", selectList);

        return "html/admin/user/userInfo";
    } //ulist


    @GetMapping("/user/userDetail")
    public ModelAndView detail(ModelAndView mv, UserDTO dto, SearchCriteria cri) {

        // 유저 디테일
        dto=service.userSelectOne(dto);
        mv.addObject("userInfo", dto);

        // 유저 배송지
        List<AddrDTO> addrList = mservice.addrList(dto.getUser_id());
        mv.addObject("addrList", addrList);

        // 쿠폰 정보
        List<CouponJoinInfoDTO> couponList = dservice.findCouponList(dto.getUser_id());
        mv.addObject("couponList", couponList);

        // 주문 정보
        cri.setUser_id(dto.getUser_id());
        mv.addObject("orderList", mservice.searchList(cri));

        System.out.println(mservice.searchList(cri));
        System.out.println(dto.getUser_id());

        mv.setViewName("html/admin/user/userDetail");

        return mv;
    } //detail

    @GetMapping("/user/addrList")
    public String addrList(Model model){

        List<AddrDTO> addrList = aservice.addrList();

        model.addAttribute("addrList", addrList);

        System.out.println("addrList = " + addrList);

        return "html/admin/user/addressInfo";
    }

    @GetMapping("/user/couponList")
    public String couponList(Model model){

        List<CouponDTO> couponList = aservice.couponList();

        model.addAttribute("couponList", couponList);

        System.out.println("couponList = " + couponList);

        return "html/admin/user/couponInfo";
    }



}