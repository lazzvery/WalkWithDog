package com.prj.web.awesome.community.vo;

import lombok.Data;

import java.util.Date;

@Data
public class QnaVO {
    private int qna_seq;
    private int attachment_file_seq;
    private String user_id;
    private String ctgr_cd;
    private String qna_title;
    private String qna_content;
    private Date qna_reg_date;
    private int qna_password;
    private String qna_secreat;
    private String qna_reply;
    private Date qna_sreply_reg_date;
}
