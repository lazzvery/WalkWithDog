package com.prj.web.awesome.user.controller;

import com.prj.web.awesome.itemDetail.service.ItemDetailService;
import com.prj.web.awesome.user.dto.HeartDTO;
import com.prj.web.awesome.user.service.HeartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RequestMapping(value = "/user")
@RequiredArgsConstructor
@Controller
public class HeartController {

    private final HeartService hservice;
    private final ItemDetailService iservice;

    @GetMapping("/heart")
    public String heart(HttpSession session, Model model){
        String loginID = (String) session.getAttribute("loginID");

        List<HeartDTO> list = hservice.findList(loginID);
        model.addAttribute("list", list);

        return "html/user/userHeart";
    }

}
