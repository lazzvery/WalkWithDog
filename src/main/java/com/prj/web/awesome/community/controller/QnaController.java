package com.prj.web.awesome.community.controller;

import com.prj.web.awesome.community.service.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/community")
@Controller
public class QnaController {

    @Autowired
    private QnaService qnaService;

    @GetMapping("/QnA")
    public String qna(Model model){
        return "html/community/QnA/communityQ&A";
    }
}
