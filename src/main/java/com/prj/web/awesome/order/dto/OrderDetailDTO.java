package com.prj.web.awesome.order.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {
    private int order_detail_code;
    private int item_price;
    private int item_count;
    private int order_code;
    private int item_id;

    private String item_name;
    private String img_name;
}
