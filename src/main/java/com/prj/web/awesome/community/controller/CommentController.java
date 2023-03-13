package com.prj.web.awesome.community.controller;

import com.prj.web.awesome.community.dto.CommentDTO;
import com.prj.web.awesome.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/commentList") //댓글 리스트
    private String commentList(Model model, CommentDTO dto) {

        List<CommentDTO> commentList = commentService.commentList();

        model.addAttribute("commentList", commentList);

        return "html/community/review/communityReviewDetail";
    }

    @PostMapping("/commentInsert") //댓글 작성
    private String commentInsert(CommentDTO dto, HttpServletRequest request) throws Exception{

        String loginID = (String) request.getSession().getAttribute("loginID");
        System.out.println("loginID = " + loginID);

        dto.setUser_id(loginID);

        System.out.println(dto);

        commentService.commentInsert(dto);


        return "redirect:reviewDetail?review_seq=" + dto.getReview_seq();
    }

    @RequestMapping("/commentUpdate") //댓글 수정
    @ResponseBody
    private int commentUpdate(@RequestParam int cno, @RequestParam String content) throws Exception{

        CommentDTO comment = new CommentDTO();
        comment.setReview_seq(cno);
        comment.setCom_content(content);

        return commentService.commentUpdate(comment);
    }

    @RequestMapping("/commentDelete/{com_seq}") //댓글 삭제
    @ResponseBody
    private int commentDelete(@PathVariable int com_seq) throws Exception{

        return commentService.commentDelete(com_seq);
    }

}

