package com.prj.web.awesome.community.controller;

import com.prj.web.awesome.community.dto.NoticeDTO;
import com.prj.web.awesome.community.dto.QnaDTO;
import com.prj.web.awesome.community.service.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/community")
@Controller
public class QnaController {

    @Autowired
    private QnaService qnaService;

    @GetMapping("/QnA")
    public String qna(Model model){

        List<QnaDTO> qnaList = qnaService.qnaList();

        model.addAttribute("qnaList", qnaList);

        return "html/community/QnA/communityQ&A";
    }
}
