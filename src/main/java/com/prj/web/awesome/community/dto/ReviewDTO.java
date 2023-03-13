package com.prj.web.awesome.community.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class ReviewDTO {
    private int review_seq;
    private int item_id;
    private String user_id;
    private String review_title;
    private String review_content;
    private LocalDate review_reg_date;
    private double review_rank;
    private int review_cnt;
    private int review_reply;
    private int review_step;
    private int review_indent;
    private int attachment_file_seq;
    private List<CommentDTO> com_content;

}
