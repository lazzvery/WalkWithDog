package com.prj.web.awesome.user.vo;

import lombok.Data;

@Data
public class CouponVO {

    private int coupon_seq;
    private String coupon_code;
    private int coupon_quantity;
    private String user_id;

}
