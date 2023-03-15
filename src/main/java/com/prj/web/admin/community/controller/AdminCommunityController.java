package com.prj.web.admin.community.controller;

import com.prj.web.awesome.community.criTest.PageNation;
import com.prj.web.awesome.community.criTest.SearchCriteria;
import com.prj.web.awesome.community.dto.FaqDTO;
import com.prj.web.awesome.community.dto.QnaDTO;
import com.prj.web.awesome.community.service.FaqService;
import com.prj.web.awesome.community.service.NoticeService;
import com.prj.web.awesome.community.service.QnaService;
import com.prj.web.awesome.community.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping(value = "/admin/community")
@Controller
public class AdminCommunityController {

    @Autowired
    private NoticeService noticeService;
    @Autowired
    private FaqService faqService;
    @Autowired
    private QnaService qnaService;
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/notice")
    public String notice(Model model){

//        List<NoticeDTO> noticeList = noticeService.noticeList();
//
//        model.addAttribute("noticeList", noticeList);

        return "html/admin/community/notice";
    }

    @GetMapping("/faq")
    public String faq(Model model){
        List<FaqDTO> faqList = faqService.faqList();

        model.addAttribute("faqList", faqList);

        return "html/admin/community/faq";
    }


    @GetMapping("/qna")
    public ModelAndView qna(ModelAndView mv, SearchCriteria cri, PageNation pageNation) {
        cri.setSnoEno();

        mv.addObject("banana", qnaService.searchList(cri));

        pageNation.setCriteria(cri);
        pageNation.setTotalRowsCount(qnaService.searchTotalCount(cri));
        mv.addObject("pageNation", pageNation);

        List<QnaDTO> qnaList = qnaService.criList(cri);

        mv.addObject("qnaList", qnaList);

        mv.setViewName("html/admin/community/qna");
        return mv;
    }



    @GetMapping("/review")
    public ModelAndView review(ModelAndView mv, SearchCriteria cri, PageNation pageNation){

        cri.setSnoEno();

        mv.addObject("reviewList", reviewService.searchList(cri));
        System.out.println("reviewService.searchList(cri) = " + reviewService.searchList(cri));


        pageNation.setCriteria(cri);
        pageNation.setTotalRowsCount(reviewService.searchTotalCount(cri));
        mv.addObject("pageNation", pageNation);

        mv.setViewName("html/admin/community/review");

        return mv;

    }
}
