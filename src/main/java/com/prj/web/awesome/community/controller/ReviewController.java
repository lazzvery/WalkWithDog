package com.prj.web.awesome.community.controller;

import com.prj.web.awesome.community.dto.FaqDTO;
import com.prj.web.awesome.community.dto.NoticeDTO;
import com.prj.web.awesome.community.dto.QnaDTO;
import com.prj.web.awesome.community.dto.ReviewDTO;
import com.prj.web.awesome.community.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RequestMapping(value = "/community")
@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/review")
    public String review(Model model){

        List<ReviewDTO> reviewList = reviewService.reviewList();

        model.addAttribute("reviewList", reviewList);

        return "html/community/review/communityReview";

    }

    @GetMapping("/reviewDetail")
    public Model reviewDetail(Model model, ReviewDTO dto){

        ReviewDTO reviewDetail = reviewService.reviewDetail(dto);

        model.addAttribute("reviewDetail", reviewDetail);

        return model;

    }

}
