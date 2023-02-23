package com.prj.web.awesome.community.service;

import com.prj.web.awesome.category.dto.CategoryDTO;
import com.prj.web.awesome.community.dto.AttachmentDTO;
import com.prj.web.awesome.community.mapper.AttachmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttachmentService {

    @Autowired
    private AttachmentMapper mapper;

    public List<AttachmentDTO> attachmentList(){
        List<AttachmentDTO> attachmentList = new ArrayList<AttachmentDTO>();

        try {
            attachmentList = mapper.attachmentList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return attachmentList;
    }


}

