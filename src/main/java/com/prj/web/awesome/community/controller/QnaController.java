package com.prj.web.awesome.community.controller;

import com.prj.web.awesome.community.criTest.PageNation;
import com.prj.web.awesome.community.criTest.SearchCriteria;
import com.prj.web.awesome.community.dto.QnaDTO;
import com.prj.web.awesome.community.service.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping(value = "/community")
@Controller
public class QnaController {

    @Autowired
    private QnaService qnaService;

    @GetMapping("/QnA")
    public ModelAndView qna(ModelAndView mv, SearchCriteria cri, PageNation pageNation) {
        cri.setSnoEno();

        mv.addObject("banana", qnaService.searchList(cri));

        pageNation.setCriteria(cri);
        pageNation.setTotalRowsCount(qnaService.searchTotalCount(cri));
        mv.addObject("pageNation", pageNation);

        List<QnaDTO> qnaList = qnaService.criList(cri);

        mv.addObject("qnaList", qnaList);

        mv.setViewName("/html/community/QnA/communityQnA");
        return mv;
    }

    @GetMapping("/qnaPassword")
    public String qnaPassword(Model model, QnaDTO dto){

        QnaDTO qnaPassword = qnaService.qnaPassword(dto);

        model.addAttribute("qnaPassword", qnaPassword);

        return "html/community/QnA/communityQnAPassword";
    }
    @PostMapping("/qnaDetail")
    public String qnaDetail(Model model, QnaDTO dto){

        QnaDTO qnaDetail = qnaService.qnaDetail(dto);

        model.addAttribute("qnaDetail", qnaDetail);

        return "html/community/QnA/communityQnADetail";
    }

    @GetMapping("/qnaInsert")
    public String qnaInsertForm(Model model){

        model.addAttribute("qnaInsert", new QnaDTO());

        return "html/community/QnA/communityWrite";
    }

    @PostMapping("/qnaInsert")
    public String qnaInsert(QnaDTO dto,HttpServletRequest request){

        QnaDTO qnaDTO = new QnaDTO();
        qnaDTO.setQna_seq(dto.getQna_seq());
        qnaDTO.setAttachment_file_seq(dto.getAttachment_file_seq());
        qnaDTO.setUser_id((String) request.getSession().getAttribute("loginID"));
        qnaDTO.setQna_title(dto.getQna_title());
        qnaDTO.setQna_content(dto.getQna_content());
        qnaDTO.setQna_reg_date(dto.getQna_reg_date());
        qnaDTO.setQna_password(dto.getQna_password());
        qnaDTO.setQna_secreat(dto.getQna_secreat());

        qnaService.qnaInsert(qnaDTO);

        return "redirect:QnA";

    }

    @GetMapping("/qnaUpdate")
    public String qnaUpdateForm(Model model, QnaDTO dto){

        System.out.println("d1" +dto);

        QnaDTO qnaDetail = qnaService.qnaDetail(dto);

        model.addAttribute("qnaDetail", qnaDetail);

        System.out.println("d2" +qnaDetail);

        return "html/community/QnA/communityQnAUpdate";
    }
    @PostMapping ("/qnaUpdate")
    public String qnaUpdate(Model model, QnaDTO dto){

        String url = "redirect:QnA";

        if (qnaService.qnaUpdate(dto) <= 0){
            url = "redirect:qnaUpdate?qna_seq=" + dto.getQna_seq();
        }

        return url;
    }

    @GetMapping("/qnaDelete")
    public String qnaDelete(QnaDTO dto){

        qnaService.qnaDelete(dto);

        return "redirect:/community/QnA";

    }

    @PostMapping("/qnaReply")
    public String qnaReply(QnaDTO dto){

        qnaService.qnaReply(dto);

        return "redirect:qnaDetail";
    }
}
