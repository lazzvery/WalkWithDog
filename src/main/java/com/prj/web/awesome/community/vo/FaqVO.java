package com.prj.web.awesome.community.vo;

import lombok.Data;

@Data
public class FaqVO {
    private int faq_seq;
    private String ctgr_cd;
    private String faq_title;
    private String faq_content;
}
