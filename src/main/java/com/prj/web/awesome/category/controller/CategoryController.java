package com.prj.web.awesome.category.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
    @GetMapping("/new")
    private String New(Model model){
        return "html/category/new";
    }
    
    @GetMapping("/living")
    private String Living(Model model){
        return "html/category/living";
    }	
    
    @GetMapping("/working")
    private String Working(Model model){
        return "html/category/working";
    }	
    
    @GetMapping("/food")
    private String Food(Model model){
        return "html/category/food";
    }	
	
    @GetMapping("/clean")
    private String Clean(Model model){
        return "html/category/clean";
    }	
    
    @GetMapping("/forcat")
    private String ForCat(Model model){
        return "html/category/forcat";
    }	
	
	
	
}
