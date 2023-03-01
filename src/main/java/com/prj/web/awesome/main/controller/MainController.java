package com.prj.web.awesome.main.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RestController
public class MainController {

    @GetMapping("/home")
    public ModelAndView getMainView() {

        ModelAndView mv = new ModelAndView();

        mv.setViewName("index");

        return mv;
    }

    @GetMapping("/clause")
    public ModelAndView getClauseView() {

        ModelAndView mv = new ModelAndView();

        mv.setViewName("html/fragments/clause");

        return mv;
    }
}
