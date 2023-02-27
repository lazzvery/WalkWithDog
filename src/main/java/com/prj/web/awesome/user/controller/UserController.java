package com.prj.web.awesome.user.controller;

import com.prj.web.awesome.user.dto.UserDTO;
import com.prj.web.awesome.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/login")
    public String login(Model model){
        return "html/user/userLogin";
    }


    @GetMapping("/join")
    public String createForm(){
        return "/html/user/userJoin";
    }

    @PostMapping("/join")
    public String create(UserDTO vo){
        // post로 넘어온 input 데이터(name)는 매개변수로 입력한 MemberForm에 있는 name에 자동으로 setName이 됨
        UserDTO member = new UserDTO();
        member.setUser_id(vo.getUser_id());
        member.setUser_password(vo.getUser_password());
        member.setUser_name(vo.getUser_name());
        member.setUser_email(vo.getUser_email());
        member.setUser_email_check(vo.getUser_email_check());
        member.setUser_phone(vo.getUser_phone());
        member.setUser_sns_check(vo.getUser_sns_check());
        member.setUser_gen(vo.getUser_gen());


        service.insert(member);

        return "redirect:/";
    }

    @GetMapping("/findid")
    public String findId(Model model){
        return "html/user/userFindId";
    }

    @GetMapping("/findpw")
    public String findpw(Model model){
        return "html/user/userFindPassword";
    }

    @GetMapping("/userList")
    public String ulist(Model model) {

        List<UserDTO> selectList = service.selectList();

        model.addAttribute("selectList", selectList);

        return "html/user/userLogin";
    } //ulist
}