package com.prj.web.awesome.item.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDto {

    private int item_id;

    private String ctgr_cd;

    private String item_name;

    private int item_price;

    private int item_amount;

    private Date item_reg_date;

    private String item_data_del_yn;

    private String item_best;

    private String img_name;
}