package com.prj.web.awesome.main.controller;

import com.prj.web.awesome.community.criTest.SearchCriteria;
import com.prj.web.awesome.community.dto.ReviewDTO;
import com.prj.web.awesome.community.service.ReviewService;
import com.prj.web.awesome.itemDetail.dto.ItemDetailDto;
import com.prj.web.awesome.itemDetail.service.ItemDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@RequestMapping
@RequiredArgsConstructor
@Controller
public class MainController {

    private final ItemDetailService iservice;
    private final ReviewService reviewService;

    @GetMapping(value = {"/", "/home"})
    public String mainHome(Model model) {
        List<ItemDetailDto> list = iservice.findList();

        List<ReviewDTO> reviewlist = reviewService.findReview();

        model.addAttribute("list", list);
        model.addAttribute("reviewList", reviewlist);
        return "index";
    }

    @GetMapping("/clause")
    public ModelAndView getClauseView() {

        ModelAndView mv = new ModelAndView();

        mv.setViewName("html/fragments/clause");

        return mv;
    }
}
