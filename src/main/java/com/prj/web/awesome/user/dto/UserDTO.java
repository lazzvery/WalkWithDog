package com.prj.web.awesome.user.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String user_id;
    private String user_password;
    private String user_name;
    private String user_email;
    private char user_email_check;
    private String user_phone;
    private char user_sns_check;
    private String user_gen;
    private String user_birthday;
    private String user_rid;
    private char admin_yn;

}
