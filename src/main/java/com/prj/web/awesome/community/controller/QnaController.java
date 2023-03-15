package com.prj.web.awesome.community.controller;

import com.prj.web.admin.upload.file.FileStore;
import com.prj.web.awesome.community.criTest.PageNation;
import com.prj.web.awesome.community.criTest.SearchCriteria;
import com.prj.web.awesome.community.dto.AttachmentDTO;
import com.prj.web.awesome.community.dto.QnaDTO;
import com.prj.web.awesome.community.dto.QnaFormDTO;
import com.prj.web.awesome.community.service.AttachmentService;
import com.prj.web.awesome.community.service.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RequestMapping(value = "/community")
@Controller
public class QnaController {

    @Autowired
    private QnaService qnaService;
    @Autowired
    private AttachmentService attachmentService;
    @Autowired
    private FileStore fileStore;

    @GetMapping("/QnA")
    public ModelAndView qna(ModelAndView mv, SearchCriteria cri, PageNation pageNation, QnaDTO dto) {

        String Img1 = attachmentService.findReviewMainImg(dto.getQna_seq());
        String Img2 = attachmentService.findReviewSubImg(dto.getQna_seq());

        cri.setSnoEno();

        mv.addObject("qnaList", qnaService.searchList(cri));

        mv.addObject("Img1", Img1);
        mv.addObject("Img2", Img2);
        System.out.println("Img1 = " + Img1);

        pageNation.setCriteria(cri);
        pageNation.setTotalRowsCount(qnaService.searchTotalCount(cri));
        mv.addObject("pageNation", pageNation);

        mv.setViewName("/html/community/QnA/communityQnA");
        return mv;
    }

    @GetMapping("/qnaPassword")
    public String qnaPassword(Model model, QnaDTO dto){

        String Img1 = attachmentService.findReviewMainImg(dto.getQna_seq());
        String Img2 = attachmentService.findReviewSubImg(dto.getQna_seq());

        QnaDTO qnaPassword = qnaService.qnaPassword(dto);

        System.out.println("Img1 = " + Img1);

        model.addAttribute("qnaPassword", qnaPassword);
        model.addAttribute("Img1", Img1);
        model.addAttribute("Img2", Img2);

        return "html/community/QnA/communityQnAPassword";
    }
    @PostMapping("/qnaDetail")
    public String qnaDetail(Model model, QnaDTO dto){

        String Img1 = attachmentService.findReviewMainImg(dto.getQna_seq());
        String Img2 = attachmentService.findReviewSubImg(dto.getQna_seq());

        QnaDTO qnaDetail = qnaService.qnaDetail(dto);

        model.addAttribute("qnaDetail", qnaDetail);
        model.addAttribute("Img1", Img1);
        model.addAttribute("Img2", Img2);

        return "html/community/QnA/communityQnADetail";
    }

    @GetMapping("/qnaInsert")
    public String qnaInsertForm(Model model){

        model.addAttribute("qnaInsert", new QnaDTO());

        return "html/community/QnA/communityWrite";
    }

    @PostMapping("/qnaInsert")
    public String qnaInsert(QnaDTO dto, HttpServletRequest request, QnaFormDTO qnaFormDTO) throws IOException  {

        System.out.println("qnaFormDTO = " + qnaFormDTO);
        System.out.println("dto = " + dto);
        dto.setUser_id((String) request.getSession().getAttribute("loginID"));
        System.out.println((String) request.getSession().getAttribute("loginID"));

        String qnamainName = fileStore.storeFile(qnaFormDTO.getImg1());
        String qnasubName = fileStore.storeFile(qnaFormDTO.getImg2());

        attachmentService.saveQnA(dto);
        int qna_seq = attachmentService.selectLastInsertSeq();
        System.out.println("qna_seq = " + qna_seq);

        saveAttachment2(qnamainName, "m", qna_seq);
        saveAttachment2(qnasubName, "s", qna_seq);

        System.out.println("qnamainName = " + qnamainName);
        return "redirect:QnA";

    }
    private void saveAttachment2(String name, String flag, int qna_seq){
        AttachmentDTO attachmentDTO = new AttachmentDTO();
        attachmentDTO.setAttachment_flag(flag);
        attachmentDTO.setAttachment_name(name);
        attachmentDTO.setQna_seq(qna_seq);
        attachmentService.saveFile2(attachmentDTO);
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
