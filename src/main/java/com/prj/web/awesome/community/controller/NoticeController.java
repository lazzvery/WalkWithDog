package com.prj.web.awesome.community.controller;

import com.prj.web.admin.upload.file.FileStore;
import com.prj.web.awesome.community.dto.AttachmentDTO;
import com.prj.web.awesome.community.dto.NoticeDTO;
import com.prj.web.awesome.community.dto.ReviewDTO;
import com.prj.web.awesome.community.service.AttachmentService;
import com.prj.web.awesome.community.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RequestMapping(value = "/community")
@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;
//    @Autowired
//    private AttachmentService attachmentService;
//    @Autowired
//    private FileStore fileStore;

    @GetMapping("/notice")
    public String notice(Model model){

        List<NoticeDTO> noticeList = noticeService.noticeList();

        model.addAttribute("noticeList", noticeList);

        return "html/community/notice/communityNotice";
    }

    @GetMapping("/noticeDetail")
    public String noticeDetail(Model model, NoticeDTO dto){

        NoticeDTO noticeDetail = noticeService.noticeDetail(dto);

        model.addAttribute("noticeDetail", noticeDetail);

        return "html/community/notice/communityNoticeDetail";
    }

    @GetMapping("/noticeInsert")
    public String noticeInsertForm(Model model){

        model.addAttribute("noticeInsert", new NoticeDTO());

        return "html/community/notice/communityNoticeWrite";
    }

//    @PostMapping("/noticeInsert")
//    public String noticeInsert(NoticeDTO dto, HttpServletRequest request, AttachmentDTO attachmentDTO) throws IOException {
//
//        String noticeMainName = fileStore.storeFile(attachmentDTO.getMainImg());
//
//        attachmentService.saveNotice(dto);
//        int notice_seq = attachmentService.selectLastInsertSeq();
//
//        saveAttachment(noticeMainName, "m", notice_seq);
//
//
//        noticeService.noticeInsert(dto);
//
//        System.out.println(dto);
//
//        return "redirect:notice";
//
//    }
//    private void saveAttachment(String name, String flag, int notice_seq){
//        AttachmentDTO attachmentDTO = new AttachmentDTO();
//        attachmentDTO.setAttachment_flag(flag);
//        attachmentDTO.setAttachment_name(name);
//        attachmentDTO.setNotice_seq(notice_seq);
//        attachmentService.saveFile(attachmentDTO);
//    }

    @GetMapping("/noticeUpdate")
    public String noticeUpdateForm(Model model, NoticeDTO dto){

        System.out.println("d1" +dto);

        NoticeDTO noticeDetail = noticeService.noticeDetail(dto);

        model.addAttribute("noticeDetail", noticeDetail);

        System.out.println("d2" +noticeDetail);

        return "html/community/notice/communityNoticeUpdate";
    }
    @PostMapping ("/noticeUpdate")
    public String reviewUpdate(Model model, NoticeDTO dto){

        String url = "redirect:notice";

        if (noticeService.noticeUpdate(dto) <= 0){
            url = "redirect:noticeUpdate?notice_seq=" + dto.getNotice_seq();
        }

        return url;
    }

    @GetMapping("/noticeDelete")
    public String noticeDelete(NoticeDTO dto){

        noticeService.noticeDelete(dto);

        return "redirect:/community/notice";

    }
}
