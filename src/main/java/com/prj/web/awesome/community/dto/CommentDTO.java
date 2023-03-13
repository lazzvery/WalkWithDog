package com.prj.web.awesome.community.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CommentDTO {
    private int com_seq;
    private int review_seq;
    private String user_id;
    private String com_content;
    private String com_re_com;
    private LocalDate com_regdate;
}
