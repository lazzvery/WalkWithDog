package com.prj.web.awesome.community.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ReviewVO {
    private int review_seq;
    private int item_id;
    private int attachment_file_seq;
    private String user_id;
    private String review_title;
    private String review_content;
    private Date review_reg_date;
    private double review_rank;
    private int review_cnt;
    private int review_reply;
    private int review_step;
    private int review_indent;
}
