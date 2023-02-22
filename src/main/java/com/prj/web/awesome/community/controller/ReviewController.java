package com.prj.web.awesome.community.controller;

import com.prj.web.awesome.community.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/community")
@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/review")
    public String review(Model model){
        return "html/community/review/communityReview";
    }
}
