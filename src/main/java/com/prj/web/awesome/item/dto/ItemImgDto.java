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
public class ItemImgDto {

    private int item_id;

    private String ctgr_cd;

//    private String prt_ctgr_cd;

    private String item_name;

}