package com.prj.web.awesome.user.dto;

import lombok.Data;

@Data
public class CouponDTO {

    private int coupon_seq;
    private String coupon_code;
    private int coupon_quantity;
    private String user_id;

}
