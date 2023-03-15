package com.prj.web.awesome.itemDetail.mapper;

import com.prj.web.awesome.item.dto.ItemDto;
import com.prj.web.awesome.itemDetail.dto.ItemDetailDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ItemDetailMapper {
    @Select("select * from item where item_id=#{item_id}")
    ItemDetailDto findItem(int item_id);

    @Select("select i.item_id, i.item_name, i.item_price, img.img_name from item i Join image img on i.item_id = img.item_id where img.img_div_flag = 'm' limit 9")
    List<ItemDetailDto> findList();

    @Select("select i.item_id, i.ctgr_cd, i.item_name, i.item_price, img.img_name from item i Join image img on i.item_id = img.item_id where img.img_div_flag = 'm' and i.ctgr_cd = #{ctgr_cd}")
    List<ItemDto> findCateList(String ctgr_cd);
}
