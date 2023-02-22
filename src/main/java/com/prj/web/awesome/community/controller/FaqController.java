package com.prj.web.awesome.community.controller;

import com.prj.web.awesome.community.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/community")
@Controller
public class FaqController {

    @Autowired
    private FaqService faqService;

    @GetMapping("/faq")
    public String faq(Model model){
        return "html/community/faq/communityFaq";
    }
}