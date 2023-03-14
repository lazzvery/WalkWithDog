package com.prj.web.awesome.community.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Data
public class QnaFormDTO {
    private int qna_seq;
    private String user_id;
    private String ctgr_cd;
    private String qna_title;
    private String qna_content;
    private LocalDate qna_reg_date;
    private int qna_password;
    private String qna_secreat;
    private MultipartFile Img1;
    private MultipartFile Img2;
}
