package com.prj.web.awesome.community.vo;

import lombok.Data;

import java.util.Date;

@Data
public class NoticeVO {
    private int notice_seq;
    private int attachment_file_seq;
    private String notice_title;
    private String notice_content;
    private Date notice_reg_date;
}
