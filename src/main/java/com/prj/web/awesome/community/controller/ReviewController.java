package com.prj.web.awesome.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewController {

    @GetMapping("/review")
    public String review(Model model){
        return "html/community/review/communityReview";
    }
}
