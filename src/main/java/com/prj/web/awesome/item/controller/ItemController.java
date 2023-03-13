package com.prj.web.awesome.item.controller;

import com.prj.web.awesome.category.dto.CategoryDTO;
import com.prj.web.awesome.category.service.CategoryService;
import com.prj.web.awesome.community.criTest.PageNation;
import com.prj.web.awesome.community.criTest.SearchCriteria;
import com.prj.web.awesome.item.dto.ItemDto;
import com.prj.web.awesome.item.payload.in.dto.ItemInDto;
import com.prj.web.awesome.item.payload.out.dto.ItemOutDto;
import com.prj.web.awesome.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Controller
public class ItemController {

//    private final ItemService itemService;

    @Autowired
    private ItemService itemService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public List<ItemOutDto> itemList(ItemInDto inDto) {
        List<ItemDto> itemArr = itemService.itemList(inDto.getCtgr_cd());

        List<ItemOutDto> itemOutArr = new ArrayList<>();

        for (ItemDto item : itemArr) {
            ItemOutDto outDto = new ItemOutDto();

            outDto.setItem_id(item.getItem_id());
            outDto.setCtgr_cd(item.getCtgr_cd());
            outDto.setItem_name(item.getItem_name());
            outDto.setItem_price(item.getItem_price());
            outDto.setItem_amount(item.getItem_amount());
            outDto.setItem_reg_date(item.getItem_reg_date());
            outDto.setItem_data_del_yn(item.getItem_data_del_yn());
            outDto.setItem_best(item.getItem_best());

            itemOutArr.add(outDto);
        }
            return itemOutArr;
    }


    // 카테고리별 리스트 컨트롤러
    @RequestMapping("/item/list2")
    public String searchCategory(String ctgr_cd, Model model, SearchCriteria cri, PageNation pageNation) {

//        cri.setSnoEno();
//        System.out.println("cri = " + cri.getRowsPerPage());
//        System.out.println("cri = " + cri.getCurrPage());
//        mv.addObject("itemList", itemService.searchList(cri));
//        System.out.println("itemService.searchList(cri) = " + itemService.searchList(cri));
//
//
//        pageNation.setCriteria(cri);
//        pageNation.setTotalRowsCount(itemService.searchTotalCount(cri));
//        mv.addObject("pageNation", pageNation);


        List<ItemDto> itemDto = itemService.itemList(ctgr_cd);
        List<CategoryDTO> categoryDTO = categoryService.searchCtgr("0001");

        model.addAttribute("ctgr_cd", ctgr_cd);
        model.addAttribute("itemDto", itemDto);
        model.addAttribute("categoryDto", categoryDTO);
        System.out.println(categoryDTO);

//        mv.setViewName("html/itemList/itemList");
//        return mv;
//
        return "html/itemList/itemList";
    }


    // BEST 카테고리 컨트롤러
    @GetMapping("/itemBest")
    public String itemBest(String item_best, Model model) {

        List<ItemDto> itemDto = itemService.itemBest(item_best);

        model.addAttribute("itemDto", itemDto);

        return "html/itemList/itemBest";
    }

    // 상품 정렬 컨트롤러
    @GetMapping("/item/list2/{category_name}")
    public String itemList(Model model, @PathVariable String category_name, String ctgr_cd) {
        System.out.println("ctgr_cd = " + ctgr_cd);
        model.addAttribute("ctgr_cd", ctgr_cd);

        if (category_name.equals("new")) {
            // category_name이 "new"인 경우에 대한 처리
            List<ItemDto> itemList1 = itemService.itemOrderNew(ctgr_cd);
            System.out.println("itemList1 = " + itemList1);
            model.addAttribute("itemDto", itemList1);
        } else if (category_name.equals("rank")) {
            List<ItemDto> itemList2 = itemService.itemOrderRank(ctgr_cd);
            System.out.println("itemList2 = " + itemList2);
            model.addAttribute("itemDto", itemList2);
        } else if (category_name.equals("low")) {
            List<ItemDto> itemList3 = itemService.itemOrderLow(ctgr_cd);
            System.out.println("itemList3 = " + itemList3);
            model.addAttribute("itemDto", itemList3);
        } else if (category_name.equals("high")) {
            List<ItemDto> itemList4 = itemService.itemOrderHigh(ctgr_cd);
            System.out.println("itemList4 = " + itemList4);
            model.addAttribute("itemDto", itemList4);
        }

        return "html/itemList/itemContainer";
//        return "html/itemList/itemList";
    }

}