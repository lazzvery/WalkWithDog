package com.prj.web.awesome.item.payload.out;

import com.prj.web.awesome.item.payload.out.dto.ItemOutDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemOutPayload {

    private List<ItemOutDto> itemOutArr;
}
