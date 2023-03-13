package com.prj.web.awesome.user.dto;

import lombok.Data;

@Data
public class HeartItemDTO {
    private int heart_code;
    private String user_id;
    private int item_id;
    private String item_name;
    private String img_name;
}
