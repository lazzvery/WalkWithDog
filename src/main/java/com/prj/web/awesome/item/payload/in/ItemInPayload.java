package com.prj.web.awesome.item.payload.in;

import com.prj.web.awesome.item.payload.in.dto.ItemInDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemInPayload {

    private ItemInDto itemInDto;
}
