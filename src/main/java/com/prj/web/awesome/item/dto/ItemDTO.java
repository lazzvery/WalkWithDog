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
public class ItemDTO {

    private String item_id;

    private String ctgr_cd;

    private String item_name;

    private String item_price;

    private String item_amount;

    private String item_reg_date;

    private String item_data_del_yn;

}