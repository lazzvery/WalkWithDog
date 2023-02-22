package com.prj.web.awesome.community.dto;

import lombok.Data;

@Data
public class FaqDTO {
    private int faq_seq;
    private String ctgr_cd;
    private String faq_title;
    private String faq_content;
}
