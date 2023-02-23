package com.prj.web.awesome.category.controller;

import java.util.List;
import java.util.Map;

import com.prj.web.awesome.category.dto.TestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.prj.web.awesome.category.dto.CategoryDTO;
import com.prj.web.awesome.category.service.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.ModelAndView;

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

	@PostMapping("/list")
	public String postCategoryList(Model model, TestDTO inDto) {
		List<CategoryDTO> categoryList = categoryService.categoryList();

		System.out.println("list ::: name : " + inDto.getName() + " | age : " + inDto.getAge());

		model.addAttribute("categoryList", categoryList);
		model.addAttribute("name", inDto.getName());
		model.addAttribute("age", inDto.getAge());

		return "index :: #categoryContainer";
	}

	@PostMapping("/list2")
	public String postCategoryList2(Model model, TestDTO inDto) {
		List<CategoryDTO> categoryList = categoryService.categoryList();

		System.out.println("list ::: name : " + inDto.getName() + " | age : " + inDto.getAge());

		model.addAttribute("categoryList", categoryList);
		model.addAttribute("name", inDto.getName());
		model.addAttribute("age", inDto.getAge());

		return "index :: #textTest";
	}

}
