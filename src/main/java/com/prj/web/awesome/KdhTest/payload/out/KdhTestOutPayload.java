package com.prj.web.awesome.KdhTest.payload.out;

import com.prj.web.awesome.KdhTest.payload.out.dto.KdhTestOutDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KdhTestOutPayload {
    private KdhTestOutDto kdhTestOutDto;
}
