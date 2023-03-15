package com.prj.web.awesome.community.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NoticeDTO {
    private int notice_seq;
    private String notice_title;
    private String notice_content;
    private LocalDate notice_reg_date;
}
