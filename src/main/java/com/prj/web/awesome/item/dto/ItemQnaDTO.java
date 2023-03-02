package com.prj.web.awesome.item.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class ItemQnaDTO {

    private int item_qna_seq;
    private String item_qna_title;
    private String item_qna_content;
    private Date item_qna_reg_date;
    private int item_qna_password;
    private String item_qna_reply;
    private int item_qna_pnum;
    private int item_id;
    private String user_id;

}
