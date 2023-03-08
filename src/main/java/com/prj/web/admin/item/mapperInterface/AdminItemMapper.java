package com.prj.web.admin.item.mapperInterface;

import com.prj.web.awesome.item.dto.ItemDto;
import com.prj.web.awesome.item.dto.ItemQnaDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminItemMapper {

//    @Select ("select * from item where item_id=#{item_id} order by item_id asc;")
//    List<ItemDto> findAll(int item_id);

    List<ItemDto> itemList();

    ItemDto itemDetail(ItemDto dto);

}
