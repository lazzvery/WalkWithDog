package com.prj.web.awesome.order.dto;

import lombok.Data;

@Data
public class CouponJoinInfoDTO {
    private int coupon_seq;
    private String coupon_code;
    private int coupon_quantity; // 쿠폰 수량
    private String user_id;
    private String coupon_name; // 쿠폰 이름
    private int coupon_buy; // 최소 주문 금액
    private int coupon_benefits; // 할인 금액
}
