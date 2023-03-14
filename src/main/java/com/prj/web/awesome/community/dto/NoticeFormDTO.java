package com.prj.web.awesome.community.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class NoticeFormDTO {
    private String notice_seq;
    private String notice_title;
    private String notice_content;
    private String notice_reg_date;
    private MultipartFile mainImg;
    private List<MultipartFile> subImg;
    private List<MultipartFile> infoImg;
}
