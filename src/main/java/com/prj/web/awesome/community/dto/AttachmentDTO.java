package com.prj.web.awesome.community.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class AttachmentDTO {
    private int attachment_file_seq;
    private int review_seq;
    private int notice_seq;
    private int qna_seq;
    private String attachment_name;
    private int attachment_order;
    private String attachment_flag;
}
