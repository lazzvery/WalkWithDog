package com.prj.web.awesome.category.payload.out;

import com.prj.web.awesome.category.payload.out.dto.CategoryOutDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryOutPayload {
    private CategoryOutDto categoryOutDto;

    private List<CategoryOutDto> arrOutDto;
}
