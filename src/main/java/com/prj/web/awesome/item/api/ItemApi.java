package com.prj.web.awesome.item.api;

import com.prj.web.awesome.item.controller.ItemController;
import com.prj.web.awesome.item.payload.in.ItemInPayload;
import com.prj.web.awesome.item.payload.out.ItemOutPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RestController
@RequestMapping("/item")
@Log4j2
public class ItemApi {

    private final ItemController controller;

    /**
     * Get은 Html 단순 호출
     * */
    @GetMapping("/list")
    public ModelAndView getResultView(String ctgr_cd) {

        ModelAndView mv = new ModelAndView();


        log.info("ctgr_cd {}", ctgr_cd);

        mv.addObject("ctgr_cd", ctgr_cd);

        mv.setViewName("html/itemList/itemList");

        return mv;
    }

    /**
     *  Post는 Jquery에서 POST 로 호출하여 리스트를 조회해옴
     *
     * @Param : inDs
     * @Return : itemOutPayload
     * */
    @PostMapping("/list")
    public ItemOutPayload getItemList(@RequestBody ItemInPayload inDs) {

        log.info("=================== inDs.getItemInDto().getCtgr_cd() : {}", inDs.getItemInDto().getCtgr_cd());


        ItemOutPayload itemOutPayload = new ItemOutPayload();

        itemOutPayload.setItemOutArr(controller.itemList(inDs.getItemInDto()));

        return itemOutPayload;
    }
}
