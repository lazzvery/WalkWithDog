package com.prj.web.awesome.category.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prj.web.awesome.category.dto.CategoryDTO;
import com.prj.web.awesome.category.service.CategoryService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@AllArgsConstructor
@RequestMapping(value="/category")
@Controller
@Log4j2
public class CategoryController {
	
	private CategoryService categoryService;
	
	@PostMapping(value = "/list")
	public String categoryList(Model model) {
		List<CategoryDTO> categoryList = categoryService.categoryList();
		model.addAttribute("categoryList", categoryList);
		return "index";
	}
	
	
}
