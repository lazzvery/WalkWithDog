package com.prj.web.admin.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prj.web.admin.board.service.AdBoardService;

@Controller
@RequestMapping(value="/admin")
public class AdBoardController {
	
	@Autowired
	private AdBoardService adBoardService;
	
//	@RequestMapping(value="/board")
//	public ModelAndView 
	
	}
