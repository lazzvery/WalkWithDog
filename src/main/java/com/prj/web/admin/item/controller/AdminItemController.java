package com.prj.web.admin.item.controller;

import com.prj.web.admin.item.service.AdminItemService;
import com.prj.web.awesome.item.dto.ItemDto;
import com.prj.web.awesome.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminItemController {

    // 어드민 상품관리
	@Autowired
	AdminItemService adminItemService;

	@GetMapping("/itemList")
	public String itemList(Model model) {

		List<ItemDto> itemList = adminItemService.itemList();

		model.addAttribute("itemList", adminItemService.itemList());
		return "html/admin/adminItem";
	}
}


//public class CategoryController {
//
//	private final CategoryService categoryService;
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