package com.prj.web.awesome.user.mapperInterface;

import com.prj.web.awesome.user.dto.HeartDTO;
import com.prj.web.awesome.user.dto.HeartItemDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HeartMapper {
    @Select("SELECT h.heart_code, h.user_id, i.item_id, i.item_name, img.img_name " +
            "FROM heart h JOIN item i ON h.item_id = i.item_id " +
            "LEFT JOIN image img ON i.item_id = img.item_id " +
            "WHERE h.user_id = #{user_id} AND img.img_div_flag = 'm'")
    List<HeartItemDTO> findHeartItem(String user_id);

    @Select("select * from heart where item_id=#{itemId} and user_id=#{userId}")
    HeartDTO findHeart(@Param("itemId") int itemId, @Param("userId") String userId);

    @Insert("insert into heart (user_id, item_id) values (#{user_id}, #{item_id})")
    void save(HeartDTO heartDTO);

    @Delete("delete from heart where item_id=#{item_id}")
    void delete(int item_id);

}