package com.prj.web.awesome.itemDetail.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
public class ItemDetailDto {
    private int item_id;
    private String ctgr_cd;
    private String item_name;
    private int item_price;
    private int item_amount;
    private Date item_reg_date;
    private String item_data_del_yn;
}