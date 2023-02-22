package com.prj.web.awesome.user.vo;

import lombok.Data;

@Data
public class UserVO {
    private String user_id;
    private String user_name;
    private String user_email;
    private char user_email_check;
    private String user_postcode;
    private String user_addr;
    private String user_addr2;
    private int user_phone;
    private char user_sns_check;
    private String user_gen;
    private int user_birthday;
    private String user_rid;
    private char admin_yn;
}
