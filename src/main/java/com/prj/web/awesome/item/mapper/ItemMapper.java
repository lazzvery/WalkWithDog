package com.prj.web.awesome.item.mapper;

import com.prj.web.awesome.item.dto.ItemDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ItemMapper {
    List<ItemDTO> itemList(String ctgr_cd);
}
