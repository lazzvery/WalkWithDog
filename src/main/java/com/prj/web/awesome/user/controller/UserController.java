package com.prj.web.awesome.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/user")
@Controller
public class UserController {

    @GetMapping("/login")
    public String login(Model model){
        return "html/user/userLogin";
    }

    @GetMapping("/join")
    public String join(Model model){
        return "html/user/userJoin";
    }

    @GetMapping("/findid")
    public String findId(Model model){
        return "html/user/userFindId";
    }

    @GetMapping("/findpw")
    public String findpw(Model model){
        return "html/user/userFindPassword";
    }
}