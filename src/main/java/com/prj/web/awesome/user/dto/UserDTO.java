package com.prj.web.awesome.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@Schema
public class UserDTO {
    private String user_id;
    private String user_password;
    private String user_name;
    private String user_email;
    private char user_email_check;
    private int user_phone;
    private char user_sns_check;
    private String user_gen;
    private int user_birthday;
    private String user_rid;
    private char admin_yn;

    public UserDTO() {

    }
}
