package com.prj.web.awesome.user.vo;

import lombok.Data;

@Data
public class AddrVO {

    private int addr_seq;
    private String addr_name;
    private String addr_reciver;
    private int addr_postcode;
    private String addr_addr;
    private String addr_addr2;
    private int addr_phone;
    private char addr_default;
    private String user_id;

}
