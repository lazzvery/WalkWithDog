package com.prj.web.awesome.item.mapper;

import com.prj.web.awesome.community.dto.NoticeDTO;
import com.prj.web.awesome.item.dto.ItemDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ItemMapper {
//    List<ItemDto> itemList() throws Exception;

    List<ItemDto> itemList(String ctgr_cd);

//    @Select("select * from item where item_best=#{Y} order by item_id asc")
    List<ItemDto> itemBest(String item_best);

//    List<ItemDto> itemSearchAll(String prt_ctgr_cd);
}
