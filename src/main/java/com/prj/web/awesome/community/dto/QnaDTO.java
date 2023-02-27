package com.prj.web.awesome.community.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class QnaDTO {
    private int qna_seq;
    private int attachment_file_seq;
    private String user_id;
    private String ctgr_cd;
    private String qna_title;
    private String qna_content;
    private LocalDate qna_reg_date;
    private int qna_password;
    private String qna_secreat;
    private String qna_reply;
    private LocalDate qna_sreply_reg_date;
}
