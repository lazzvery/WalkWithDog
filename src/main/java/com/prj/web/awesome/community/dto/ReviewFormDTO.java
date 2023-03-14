package com.prj.web.awesome.community.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Data
public class ReviewFormDTO {
    private int review_seq;
    private int item_id;
    private String user_id;
    private String review_title;
    private String review_content;
    private LocalDate review_reg_date;
    private double review_rank;
    private MultipartFile Img1;
    private MultipartFile Img2;
    private MultipartFile Img3;

}
