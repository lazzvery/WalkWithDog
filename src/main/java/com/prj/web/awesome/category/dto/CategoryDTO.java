package com.prj.web.awesome.category.dto;

import lombok.Data;

@Data
public class CategoryDTO {
	private String ctgr_cd;
	private String ctgr_nm;
	private int ctgr_order;
	private String prt_ctgr_cd;
	private String use_yn;
}
