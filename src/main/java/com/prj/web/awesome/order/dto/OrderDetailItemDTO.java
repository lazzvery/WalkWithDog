package com.prj.web.awesome.order.dto;

import lombok.Data;

@Data
public class OrderDetailItemDTO {
    private int item_price;
    private int item_amount;
    private int item_id;
    private String item_name;
}
