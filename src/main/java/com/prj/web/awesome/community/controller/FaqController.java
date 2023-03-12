package com.prj.web.awesome.community.controller;

import com.prj.web.awesome.community.dto.FaqDTO;
import com.prj.web.awesome.community.dto.NoticeDTO;
import com.prj.web.awesome.community.dto.QnaDTO;
import com.prj.web.awesome.community.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping(value = "/community")
@Controller
public class FaqController {

    @Autowired
    private FaqService faqService;

    @GetMapping("/faq")
    public String faq(Model model){
        List<FaqDTO> faqList = faqService.faqList();

        model.addAttribute("faqList", faqList);

        return "html/community/faq/communityFaq";
    }

    @GetMapping("/faqInsert")
    public String faqInsertForm(Model model){

        model.addAttribute("faqInsert", new FaqDTO());

        return "html/community/faq/communityFaqWrite";
    }

    @PostMapping("/faqInsert")
    public String faqInsert(FaqDTO dto, HttpServletRequest request){

        FaqDTO faqDTO = new FaqDTO();
        faqDTO.setFaq_seq(dto.getFaq_seq());
        faqDTO.setFaq_title(dto.getFaq_title());
        faqDTO.setFaq_content(dto.getFaq_content());
        faqDTO.setCtgr_cd(dto.getCtgr_cd());

        faqService.faqInsert(faqDTO);

        return "redirect:faq";

    }

    @GetMapping("/faqUpdate")
    public String faqUpdateForm(Model model, FaqDTO dto){

        System.out.println("d1" +dto);

        FaqDTO faqDetail = (FaqDTO)faqService.faqList();

        model.addAttribute("faqDetail", faqDetail);

        System.out.println("d2" +faqDetail);

        return "html/community/QnA/communityQnAUpdate";
    }
    @PostMapping ("/faqUpdate")
    public String qnaUpdate(Model model, FaqDTO dto){

        String url = "redirect:faq";

        if (faqService.faqUpdate(dto) <= 0){
            url = "redirect:faqUpdate?faq_seq=" + dto.getFaq_seq();
        }

        return url;
    }

    @GetMapping("/faqDelete")
    public String faqDelete(FaqDTO dto){

        faqService.faqDelete(dto);

        return "redirect:/community/faq";

    }
}