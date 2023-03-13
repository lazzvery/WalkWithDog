package com.prj.web.awesome.item.mapper;

import com.prj.web.awesome.community.criTest.Criteria;
import com.prj.web.awesome.community.criTest.SearchCriteria;
import com.prj.web.awesome.community.dto.NoticeDTO;
import com.prj.web.awesome.community.dto.ReviewDTO;
import com.prj.web.awesome.item.dto.ItemDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ItemMapper {
//    List<ItemDto> itemList() throws Exception;

    List<ItemDto> itemList(String ctgr_cd);

    List<ItemDto> itemBest(String item_best);


    // 신상품순 정렬
    List<ItemDto> itemOrderNew(String ctgr_cd);

    List<ItemDto> itemOrderRank(String ctgr_cd);

    List<ItemDto> itemOrderLow(String ctgr_cd);

    List<ItemDto> itemOrderHigh(String ctgr_cd);

    List<ItemDto> searchList(SearchCriteria cri);
    int searchTotalCount(SearchCriteria cri);

    List<ItemDto> criList(Criteria cri);
    int criTotalCount();

//    List<ItemDto> itemSearchAll(String prt_ctgr_cd);
}
