package com.prj.web.awesome.KdhTest.payload.in.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KdhTestInDto {

    private String userId;

    private String pwd;

    private String name;

    private String age;

    private String email;

    private String addr;

}
