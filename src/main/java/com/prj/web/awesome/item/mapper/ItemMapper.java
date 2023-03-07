package com.prj.web.awesome.item.mapper;

import com.prj.web.awesome.community.dto.NoticeDTO;
import com.prj.web.awesome.item.dto.ItemDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ItemMapper {
//    List<ItemDto> itemList() throws Exception;

    List<ItemDto> itemList(String ctgr_cd);

//    List<ItemDto> itemSearchAll(String prt_ctgr_cd);
}
