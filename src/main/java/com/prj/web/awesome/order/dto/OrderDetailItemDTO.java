package com.prj.web.awesome.order.dto;

import lombok.Data;

@Data
public class OrderDetailItemDTO {
    private int order_detail_code;
    private int order_code;
    private int item_id;
    private int item_price;
    private int item_count;
    private String item_name;
}
