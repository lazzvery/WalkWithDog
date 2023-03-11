package com.prj.web.admin.upload.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ItemFormDTO {
    private String ctgr_cd;
    private String item_name;
    private int item_price;
    private int item_amount;
    private MultipartFile mainImage;
    private List<MultipartFile> subImages;
}
