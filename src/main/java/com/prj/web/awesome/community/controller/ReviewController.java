package com.prj.web.awesome.community.controller;

import com.prj.web.awesome.community.criTest.PageNation;
import com.prj.web.awesome.community.criTest.SearchCriteria;
import com.prj.web.awesome.community.dto.FaqDTO;
import com.prj.web.awesome.community.dto.NoticeDTO;
import com.prj.web.awesome.community.dto.QnaDTO;
import com.prj.web.awesome.community.dto.ReviewDTO;
import com.prj.web.awesome.community.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ModelAndView review(ModelAndView mv, SearchCriteria cri, PageNation pageNation){

        cri.setSnoEno();

        mv.addObject("banana", reviewService.searchList(cri));

        pageNation.setCriteria(cri);
        pageNation.setTotalRowsCount(reviewService.searchTotalCount(cri));
        mv.addObject("pageNation", pageNation);

        List<ReviewDTO> reviewList = reviewService.criList(cri);

        mv.addObject("reviewList", reviewList);

        mv.setViewName("html/community/review/communityReview");

        return mv;

    }

    @PostMapping("/reviewDetail")
    public String reviewDetail(Model model, ReviewDTO dto){

        ReviewDTO reviewDetail = reviewService.reviewDetail(dto);

        model.addAttribute("reviewDetail", reviewDetail);

        return "html/community/review/communityReviewDetail";

    }
@GetMapping("/reviewInsert")
public String reviewInsertForm(Model model){

    model.addAttribute("reviewInsert", new ReviewDTO());

    return "html/community/review/communityReviewWrite";
}

    @PostMapping("/reviewInsert")
    public String reviewInsert(ReviewDTO dto,HttpServletRequest request){

        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setReview_seq(dto.getReview_seq());
        reviewDTO.setItem_id(dto.getItem_id());
        reviewDTO.setAttachment_file_seq(dto.getAttachment_file_seq());
        reviewDTO.setUser_id((String) request.getSession().getAttribute("loginID"));
        reviewDTO.setReview_title(dto.getReview_title());
        reviewDTO.setReview_content(dto.getReview_content());
        reviewDTO.setReview_reg_date(dto.getReview_reg_date());
        reviewDTO.setReview_rank(dto.getReview_rank());

        reviewService.reviewInsert(reviewDTO);

        System.out.println(reviewDTO);
        return "redirect:review";

    }

    @GetMapping("/reviewUpdate")
    public String reviewUpdateForm(Model model, ReviewDTO dto){

        System.out.println("d1" +dto);

        ReviewDTO reviewDetail = reviewService.reviewDetail(dto);

        model.addAttribute("reviewDetail", reviewDetail);

        System.out.println("d2" +reviewDetail);

        return "html/community/QnA/communityReviewUpdate";
    }
    @PostMapping ("/reviewUpdate")
    public String reviewUpdate(Model model, ReviewDTO dto){

        String url = "redirect:review";

        if (reviewService.reviewUpdate(dto) <= 0){
            url = "redirect:reviewUpdate?review_seq=" + dto.getReview_seq();
        }

        return url;
    }

    @GetMapping("/reviewDelete")
    public String reviewDelete(ReviewDTO dto){

        reviewService.reviewDelete(dto);

        return "redirect:/community/review";

    }
}
