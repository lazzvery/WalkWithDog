package com.prj.web.awesome.community.controller;

import com.prj.web.awesome.community.dto.AttachmentDTO;
import com.prj.web.awesome.community.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/community")
@Controller
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    @GetMapping("/attachment")
    public String attachment(Model model){

        List<AttachmentDTO> attachmentList = attachmentService.attachmentList();

        model.addAttribute("attachmentList", attachmentList);

        return "";
    }

}
