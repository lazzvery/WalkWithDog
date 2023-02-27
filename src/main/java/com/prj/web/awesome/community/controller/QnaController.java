package com.prj.web.awesome.community.controller;

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

        return "html/community/QnA/communityQnA";
    }
    @GetMapping("/qnaPassword")
    public String qnaPassword(Model model, QnaDTO dto){

        QnaDTO qnaPassword = qnaService.qnaPassword(dto);

        System.out.print(qnaPassword);

        model.addAttribute("qnaPassword", qnaPassword);

        return "html/community/QnA/communityQnAPassword";
    }@GetMapping("qnaDetail")
    public String qnaDetail(Model model, QnaDTO dto){

        QnaDTO qnaDetail = qnaService.qnaDetail(dto);

        System.out.print(qnaDetail);

        model.addAttribute("qnaDetail", qnaDetail);

        return "html/community/QnA/communityQnADetail";
    }
}
