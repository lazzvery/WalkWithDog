package com.prj.web.admin.upload.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ImageDTO {
    private int img_file_seq;
    private String img_div_flag;    // 이미지 용도 구분
    private String img_name;    // 파일명
    private Date img_reg_date;
    private String img_data_del_yn;     // 삭제 여부
    private int img_order;  // 이미지 순서
    private int item_id;    // 상품 아이디
}
