package com.prj.web.awesome.category.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.web.awesome.category.dto.CategoryDTO;
import com.prj.web.awesome.category.mapper.CategoryMapper;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CategoryService {
	
	@Autowired
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


