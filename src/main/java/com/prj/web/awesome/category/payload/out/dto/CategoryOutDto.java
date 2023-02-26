package com.prj.web.awesome.category.payload.out.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryOutDto {
    private String ctgr_cd;
    private String ctgr_nm;
    private int ctgr_order;
    private String prt_ctgr_cd;
    private String use_yn;
}
