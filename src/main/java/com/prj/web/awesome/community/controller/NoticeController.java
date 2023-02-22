package com.prj.web.awesome.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeController {

    @GetMapping("/notice")
    public String notice(Model model){
        return "html/community/notice/communityNotice";
    }
}
