package com.prj.web.awesome.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prj.web.awesome.category.dto.CategoryDTO;
import com.prj.web.awesome.category.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/list")
	public String categoryList(Model model) {
		List<CategoryDTO> categoryList = categoryService.categoryList();
		
		model.addAttribute("categoryList", categoryList);
		return "index";
	}
	
	
}
