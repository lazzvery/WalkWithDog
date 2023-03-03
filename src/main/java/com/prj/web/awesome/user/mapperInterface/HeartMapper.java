package com.prj.web.awesome.user.mapperInterface;

import com.prj.web.awesome.user.dto.HeartDTO;
import com.prj.web.awesome.user.dto.HeartItemDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HeartMapper {
    @Select("SELECT h.heart_code, h.user_id, h.item_id, i.item_name " +
            "FROM heart h JOIN item i ON h.item_id = i.item_id " +
            "WHERE h.user_id = #{user_id}")
    List<HeartItemDTO> findHeartItem(String user_id);

    @Select("select * from heart where item_id=#{item_id} and user_id=#{user_id}")
    HeartDTO findHeart(int item_id, String user_id);

    @Insert("insert into heart (user_id, item_id) values (#{user_id}, #{item_id})")
    void save(HeartDTO heartDTO);

    @Delete("delete from heart where item_id=#{item_id}")
    void delete(int item_id);

}