package com.prj.web.awesome.community.controller;

import com.prj.web.awesome.community.dto.FaqDTO;
import com.prj.web.awesome.community.dto.NoticeDTO;
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

//    @GetMapping("/detail")
//    public Model detail(HttpServletRequest request, Model model, ReviewDTO dto){
//
////        dto = reviewService.reviewList(dto);
////        if(dto != null){
////            String loginID = (String)request.getSession().getAttribute("loginID");
////            if(!dto.getUser_id().equals(loginID) && !"admin".equals(loginID) && !"U".equals(request.getParameter("jCode")) ){
////                if(reviewService.countUp(dto)){
////                    dto.setReview_cnt(dto.getReview_cnt() + 1);
////                }
////            }
////        }
//
//        model.addAttribute("reviewDetail", reviewDetail);
//
//        return model;
//
//    }
}
