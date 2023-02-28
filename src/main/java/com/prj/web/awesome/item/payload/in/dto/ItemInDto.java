package com.prj.web.awesome.item.payload.in.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemInDto {
    private String ctgr_cd;
    private String prt_ctgr_cd;
}
