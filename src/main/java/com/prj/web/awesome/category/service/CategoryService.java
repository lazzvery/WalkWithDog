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
	
	private final CategoryMapper mapper;
	
	public List<CategoryDTO> categoryList(){
		List<CategoryDTO> categoryList = new ArrayList<CategoryDTO>();
		
		try {
			categoryList = mapper.categoryList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return categoryList;
	}

	public List<CategoryDTO> searchCtgr(String prt_ctgr_cd){
		List<CategoryDTO> searchCtgr = new ArrayList<CategoryDTO>();

		try {
			searchCtgr = mapper.searchCtgr(prt_ctgr_cd);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return searchCtgr;
	}

}


