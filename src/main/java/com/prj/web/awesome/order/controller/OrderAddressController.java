package com.prj.web.awesome.order.controller;

import com.prj.web.awesome.order.service.OrderAddressService;
import com.prj.web.awesome.user.dto.AddrDTO;
import com.prj.web.awesome.user.service.MyPageService;
import com.prj.web.awesome.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping(value = "/order")
@Controller
public class OrderAddressController {

    @Autowired
    MyPageService service;
    @Autowired
    UserService uservice;
    @Autowired
    OrderAddressService oservice;

    @GetMapping("/addrList")
    public String addrList(Model model, HttpServletRequest request) {


        List<AddrDTO> loginID = service.addrList((String) request.getSession().getAttribute("loginID"));

        model.addAttribute("addrList", loginID);


        return "html/order/orderAddress";
    } //ulist

//    @GetMapping("/addrList")
//    public String addrUpdatef(Model mv , AddrDTO dto, HttpServletRequest request) throws IOException {
//        dto.setUser_id((String)request.getSession().getAttribute("loginID"));
//
//        dto = service.addrSelectOne(dto);
//        mv.addAttribute("addrInfo", dto);
//
//        System.out.println(dto);
//
//        return "/html/order/orderAddress";
//    }
    @ResponseBody
    @PostMapping("/addrList")
    public String addrUpdate(@RequestBody Integer item, HttpServletRequest request) {
        String loginID = (String) request.getSession().getAttribute("loginID");


            AddrDTO addrDTO = new AddrDTO();
            addrDTO.setAddr_seq(item);
            addrDTO.setUser_id(loginID);
            addrDTO.setAddr_default('Y');
            service.insertAddrUpdate(addrDTO);
            oservice.addrUpdate(addrDTO);


        System.out.println("item = " + item);

        return "redirect:/order/orderDetail";
    } //delete

}
