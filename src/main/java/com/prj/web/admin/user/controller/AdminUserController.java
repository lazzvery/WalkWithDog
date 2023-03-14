package com.prj.web.admin.user.controller;

import com.prj.web.admin.user.service.AdminMyPageService;
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

import javax.servlet.http.HttpServletRequest;
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

    // 유저 리스트
    @GetMapping("/user/userInfo")
    public String ulist(Model model) {

        List<UserDTO> selectList = service.selectList();

        model.addAttribute("selectList", selectList);

        return "html/admin/user/userInfo";
    } //ulist


    @GetMapping("/user/userDetail")
    public ModelAndView detail(HttpServletRequest request, ModelAndView mv, UserDTO dto) {

        // => 처리순서 : parameter확인: 없으면 -> session 확인 -> Update요청여부 확인
        if ( dto.getUser_id()==null || dto.getUser_id().length()<1 ) {
            // => session 확인
            if ( request.getSession().getAttribute("loginID")!=null ) {
                dto.setUser_id((String)request.getSession().getAttribute("loginID"));
            }
        } // vo확인

        // 2) Service
        dto=service.userSelectOne(dto);
        mv.addObject("userInfo", dto);

        System.out.println(dto);
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