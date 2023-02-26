package com.prj.web.awesome.category.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.prj.web.awesome.category.dto.TestDTO;
import com.prj.web.awesome.category.payload.out.dto.CategoryOutDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.prj.web.awesome.category.dto.CategoryDTO;
import com.prj.web.awesome.category.service.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Component
@Log4j2
public class CategoryController {

	private final CategoryService categoryService;

	public List<CategoryOutDto> searchAllCtgr() {
		List<CategoryDTO> categoryList = categoryService.categoryList();

		List<CategoryOutDto> arrDto = new ArrayList<>();

		for (CategoryDTO dto : categoryList) {
			CategoryOutDto outDto = new CategoryOutDto();


			outDto.setCtgr_cd(dto.getCtgr_cd());
			outDto.setCtgr_nm(dto.getCtgr_nm());
			outDto.setCtgr_order(dto.getCtgr_order());
			outDto.setPrt_ctgr_cd(dto.getPrt_ctgr_cd());
			outDto.setUse_yn(dto.getUse_yn());

			arrDto.add(outDto);
		}

		return arrDto;
	}
}
