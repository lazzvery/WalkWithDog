package com.prj.web.awesome.category.api;

import com.prj.web.awesome.category.controller.CategoryController;
import com.prj.web.awesome.category.payload.out.CategoryOutPayload;
import com.prj.web.awesome.category.payload.out.dto.CategoryOutDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
@Log4j2
public class categoryApi {

    private final CategoryController controller;

    @PostMapping("/list")
    public CategoryOutPayload searchAllCtgr() {
        List<CategoryOutDto> arrDto = controller.searchAllCtgr();

        CategoryOutPayload pyld = new CategoryOutPayload();

        pyld.setArrOutDto(arrDto);

        return pyld;
    }
}
