package com.prj.web.awesome.user.dto;

import lombok.Data;

@Data
public class CouponInfoDTO {
    private String coupon_code;
    private String coupon_name;
    private int coupon_buy;
    private int coupon_benefits;
}
