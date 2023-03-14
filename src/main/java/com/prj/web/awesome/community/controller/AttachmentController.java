//package com.prj.web.awesome.community.controller;
//
//import com.prj.web.admin.upload.file.FileStore;
//import com.prj.web.awesome.community.dto.*;
//import com.prj.web.awesome.community.service.AttachmentService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.io.IOException;
//import java.util.List;
//
//@Slf4j
//@Controller
//@RequiredArgsConstructor
//public class AttachmentController {
//
//    private final AttachmentService attachmentService;
//    private final FileStore fileStore;
//
//    @GetMapping("/noticeupload")
//    public String noticeForm(Model model){
//
//        model.addAttribute("noticeInsert", new NoticeDTO());
//
//        return "html/admin/community/notice";
//
//    }
//
//    @PostMapping("/attachment/noticeupload")
//    public String saveNotice(NoticeFormDTO noticeFormDTO, NoticeDTO noticeDTO) throws IOException{
//        String noticemainName = fileStore.storeFile(noticeFormDTO.getMainImg());
//
//        attachmentService.saveNotice(noticeDTO);
//        int notice_seq = attachmentService.selectLastInsertSeq();
//
//        saveAttachment(noticemainName, "m", notice_seq);
//
//        return "html/community/notice/communityNotice";
//
//    }
//
//    private void saveAttachment(String name, String flag, int notice_seq){
//        AttachmentDTO attachmentDTO = new AttachmentDTO();
//        attachmentDTO.setAttachment_flag(flag);
//        attachmentDTO.setAttachment_name(name);
//        attachmentDTO.setNotice_seq(notice_seq);
//        attachmentService.saveFile(attachmentDTO);
//    }
//

//
//    @PostMapping("/attachment/reviewupload")
//    public String saveReview(ReviewFormDTO reviewFormDTO, ReviewDTO reviewDTO) throws IOException{
//
//        String reviewmainName = fileStore.storeFile(reviewFormDTO.getMainImg());
//        List<String> reviewsubName = fileStore.storeFiles(reviewFormDTO.getSubImg());
//        List<String> reviewinfoName = fileStore.storeFiles(reviewFormDTO.getInfoImg());
//
//        attachmentService.saveReview(reviewDTO);
//        int review_seq = attachmentService.selectLastInsertSeq();
//
//        saveAttachment3(reviewmainName, "m", review_seq);
//        for (String sub : reviewsubName){
//            saveAttachment3(sub, "s", review_seq);
//        }
//        for (String info : reviewinfoName){
//            saveAttachment3(info, "i", review_seq);
//        }
//
//        return "html/community/review/communityReview";
//
//    }
//
//    private void saveAttachment3(String name, String flag, int review_seq){
//        AttachmentDTO attachmentDTO = new AttachmentDTO();
//        attachmentDTO.setAttachment_flag(flag);
//        attachmentDTO.setAttachment_name(name);
//        attachmentDTO.setReview_seq(review_seq);
//        attachmentService.saveFile(attachmentDTO);
//    }
//
//}
