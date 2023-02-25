package com.prj.web.awesome.user.dto;

import lombok.Data;

@Data
public class CartDTO {

    private int cart_code;
    private int cart_amount;
    private String user_id;
    private int item_id;

}
