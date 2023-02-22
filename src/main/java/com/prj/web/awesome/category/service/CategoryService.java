package com.prj.web.awesome.category.service;

import java.util.ArrayList;
import java.util.List;

import com.prj.web.awesome.category.dto.CategoryDTO;
import com.prj.web.awesome.category.mapper.CategoryMapper;

public class CategoryService {
	
	private CategoryMapper mapper;
	
	public List<CategoryDTO> categoryList(){
		List<CategoryDTO> categoryList = new ArrayList<CategoryDTO>();
		
		try {
			categoryList = mapper.categoryList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return categoryList;
	}

}


