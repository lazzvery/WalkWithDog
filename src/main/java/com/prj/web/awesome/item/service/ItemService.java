package com.prj.web.awesome.item.service;

import com.prj.web.awesome.community.criTest.SearchCriteria;
import com.prj.web.awesome.item.dto.ItemDto;
import com.prj.web.awesome.item.dto.ItemImgDto;
import com.prj.web.awesome.item.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemMapper mapper;

    public List<ItemDto> itemList(String ctgr_cd) {
        return mapper.itemList(ctgr_cd);
    }

    public List<ItemDto> itemBest(String item_best) {

        return mapper.itemBest(item_best);
    }

    // 최신 등록한 순서대로
//    public List<ItemDto> getItemListByNew() {
//        List<ItemDto> itemList = mapper.itemOrderNew();
//        List<ItemDto> itemDtoList = itemList.stream()
//                .map(item -> new ItemDto(item))
//                .collect(Collectors.toList());
//        return itemDtoList;
//    }

    // 신상품순
    public List<ItemDto> itemOrderNew(String ctgr_cd) {
        return mapper.itemOrderNew(ctgr_cd);
    }

    // 인기상품순
    public List<ItemDto> itemOrderRank(String ctgr_cd) {
        return mapper.itemOrderRank(ctgr_cd);
    }

    // 낮은가격
    public List<ItemDto> itemOrderLow(String ctgr_cd) {
        return mapper.itemOrderLow(ctgr_cd);
    }

    // 높은가격
    public List<ItemDto> itemOrderHigh(String ctgr_cd) {
        return mapper.itemOrderHigh(ctgr_cd);
    }

    public List<ItemDto> searchList(SearchCriteria cri){
        return mapper.searchList(cri);
    };

    public int searchTotalCount(SearchCriteria cri){
        return mapper.searchTotalCount(cri);
    };


    // 상품 검색
    public List<ItemDto> itemSearch(String keyword) {
        return mapper.itemSearch(keyword); //keyword 파라미터 전달
    }


//    public List<ItemImgDto> findItemImg(String prt_ctgr_cd) {
//        return mapper.findItemImg(prt_ctgr_cd);
//    }

}