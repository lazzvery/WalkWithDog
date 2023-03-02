package com.prj.web.awesome.itemDetail.mapper;

import com.prj.web.awesome.itemDetail.dto.ItemDetailDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ItemDetailMapper {
    @Select("select * from item where item_id=#{item_id}")
    ItemDetailDto findItem(int item_id);
}
