package com.prj.web.awesome.community.controller;

import com.prj.web.admin.upload.file.FileStore;
import com.prj.web.awesome.community.criTest.PageNation;
import com.prj.web.awesome.community.criTest.SearchCriteria;
import com.prj.web.awesome.community.dto.*;
import com.prj.web.awesome.community.service.AttachmentService;
import com.prj.web.awesome.community.service.CommentService;
import com.prj.web.awesome.community.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.lang.model.SourceVersion;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.List;

@RequestMapping(value = "/community")
@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private AttachmentService attachmentService;
    @Autowired
    private FileStore fileStore;

    @GetMapping("/review")
    public ModelAndView review(ModelAndView mv, SearchCriteria cri, PageNation pageNation, ReviewDTO dto){

        String Img1 = attachmentService.findReviewMainImg(dto.getReview_seq());
        String Img2 = attachmentService.findReviewSubImg(dto.getReview_seq());
        String Img3 = attachmentService.findReviewInfoImg(dto.getReview_seq());

        cri.setSnoEno();

        mv.addObject("reviewList", reviewService.searchList(cri));
        System.out.println("reviewService.searchList(cri) = " + reviewService.searchList(cri));

        mv.addObject("Img1", Img1);
        mv.addObject("Img2", Img2);
        mv.addObject("Img3", Img3);


        pageNation.setCriteria(cri);
        pageNation.setTotalRowsCount(reviewService.searchTotalCount(cri));
        mv.addObject("pageNation", pageNation);

        mv.setViewName("html/community/review/communityReview");

        return mv;

    }

    @GetMapping("/reviewDetail")
    public String reviewDetail(Model model, ReviewDTO dto, CommentDTO dto2){

        String Img1 = attachmentService.findReviewMainImg(dto.getReview_seq());
        String Img2 = attachmentService.findReviewSubImg(dto.getReview_seq());
        String Img3 = attachmentService.findReviewInfoImg(dto.getReview_seq());

        ReviewDTO reviewDetail = reviewService.reviewDetail(dto);
        List<CommentDTO> commentList = commentService.commentList(dto2);

        model.addAttribute("reviewDetail", reviewDetail);
        model.addAttribute("commentList", commentList);
        model.addAttribute("Img1", Img1);
        model.addAttribute("Img2", Img2);
        model.addAttribute("Img3", Img3);

        return "html/community/review/communityReviewDetail";

    }
@GetMapping("/reviewInsert")
public String reviewInsertForm(Model model){

    model.addAttribute("reviewInsert", new ReviewDTO());

    return "html/community/review/communityReviewWrite";
}

    @PostMapping("/reviewInsert")
    public String reviewInsert(ReviewDTO dto,HttpServletRequest request, ReviewFormDTO reviewFormDTO) throws IOException {

        dto.setUser_id((String) request.getSession().getAttribute("loginID"));

        String reviewmainName = fileStore.storeFile(reviewFormDTO.getImg1());
        String reviewsubName = fileStore.storeFile(reviewFormDTO.getImg2());
        String reviewinfoName = fileStore.storeFile(reviewFormDTO.getImg3());

        attachmentService.saveReview(dto);
        int review_seq = attachmentService.selectLastInsertSeq();

        saveAttachment3(reviewmainName, "m", review_seq);
        saveAttachment3(reviewsubName, "s", review_seq);
        saveAttachment3(reviewinfoName, "i", review_seq);

        return "redirect:review";
    }

    private void saveAttachment3(String name, String flag, int review_seq){
        System.out.println("flag = " + flag);
        AttachmentDTO attachmentDTO = new AttachmentDTO();
        attachmentDTO.setAttachment_name(name);
        attachmentDTO.setAttachment_flag(flag);
        attachmentDTO.setReview_seq(review_seq);
        attachmentService.saveFile3(attachmentDTO);
    }

    @GetMapping("/reviewUpdate")
    public String reviewUpdateForm(Model model, ReviewDTO dto){

        System.out.println("d1" +dto);

        ReviewDTO reviewDetail = reviewService.reviewDetail(dto);

        model.addAttribute("reviewDetail", reviewDetail);

        System.out.println("d2" +reviewDetail);

        return "html/community/review/communityReviewUpdate";
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
