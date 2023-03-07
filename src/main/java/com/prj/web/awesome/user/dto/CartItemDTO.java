package com.prj.web.awesome.user.dto;

import lombok.Data;

@Data
public class CartItemDTO {
    private int cart_code;
    private int cart_amount;
    private String user_id;
    private int item_id;
    private String item_name;
    private int item_price;
}
