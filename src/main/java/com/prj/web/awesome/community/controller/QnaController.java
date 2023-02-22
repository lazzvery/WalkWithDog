package com.prj.web.awesome.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QnaController {

    @GetMapping("/QnA")
    public String qna(Model model){
        return "html/community/QnA/communityQ&A";
    }
}
