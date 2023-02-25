package com.prj.web.awesome.KdhTest.payload.in;

import com.prj.web.awesome.KdhTest.payload.in.dto.KdhTestInDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KdhTestInPayload {

    private KdhTestInDto kdhTestInDto;

}
