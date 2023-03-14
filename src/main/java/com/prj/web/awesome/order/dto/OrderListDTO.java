package com.prj.web.awesome.order.dto;


import lombok.Data;

import java.sql.Date;


@Data
public class OrderListDTO {

    private int order_code;
    private Date order_date;
    private int order_price;
    private String order_payment;
    private String order_status;
    private String order_claim;
    private String user_id;
    private String coupon_code;
    private int addr_seq;

    private int order_count;

}
