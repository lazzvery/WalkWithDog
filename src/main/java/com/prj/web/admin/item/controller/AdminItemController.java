package com.prj.web.admin.item.controller;

import com.prj.web.admin.item.service.AdminItemService;
import com.prj.web.awesome.category.service.CategoryService;
import com.prj.web.awesome.item.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/admin/item")
@Controller
public class AdminItemController {

    // 어드민 상품관리
	@Autowired
	AdminItemService adminItemService;
	@Autowired
	CategoryService categoryService;

	@GetMapping("/itemInfo")
	public String itemList(Model model) {

		List<ItemDto> itemList = adminItemService.itemList();

		model.addAttribute("itemList", adminItemService.itemList());
		return "html/admin/item/itemInfo";
	}


	@GetMapping("/itemInsert")
	public String itemInsert(Model model){
		return "html/admin/item/itemInsert";
	}

	@GetMapping("/itemQna")
	public String itemQna(Model model){
		return "html/admin/item/itemQna";
	}

	@GetMapping("/category")
	public String category(Model model){
		return "html/admin/item/category";
	}

	@GetMapping("/image")
	public String image(Model model){
		return "html/admin/item/image";
	}

	@GetMapping("/imageInsert")
	public String imageInsert(Model model){
		return "html/admin/item/imageInsert";
	}





}


//public class CategoryController {
//
//
//
//	public List<CategoryOutDto> searchAllCtgr() {
//		List<CategoryDTO> categoryList = categoryService.categoryList();
//
//		List<CategoryOutDto> arrDto = new ArrayList<>();
//
//		for (CategoryDTO dto : categoryList) {
//			CategoryOutDto outDto = new CategoryOutDto();
//
//
//			outDto.setCtgr_cd(dto.getCtgr_cd());
//			outDto.setCtgr_nm(dto.getCtgr_nm());
//			outDto.setCtgr_order(dto.getCtgr_order());
//			outDto.setPrt_ctgr_cd(dto.getPrt_ctgr_cd());
//			outDto.setUse_yn(dto.getUse_yn());
//
//			arrDto.add(outDto);
//		}
//
//		return arrDto;
//	}
//}


