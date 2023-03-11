package com.prj.web.admin.upload.mapper;

import com.prj.web.admin.upload.dto.ImageDTO;
import com.prj.web.awesome.item.dto.ItemDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ImageMapper {
    @Insert("insert into image (img_div_flag, img_name, img_reg_date, item_id) " +
            "values (#{img_div_flag}, #{img_name}, NOW(), #{item_id})")
    void saveFile(ImageDTO imageDTO);

    @Insert("insert into item (ctgr_cd, item_name, item_price, item_amount, item_reg_date) " +
            "values (#{ctgr_cd}, #{item_name}, #{item_price}, #{item_amount}, NOW())")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="item_id", before=false, resultType=int.class)
    void saveItem(ItemDto itemDto);

    @Select("SELECT LAST_INSERT_ID()")
    int selectLastInsertId();
}
