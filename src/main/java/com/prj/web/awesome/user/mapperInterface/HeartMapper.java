package com.prj.web.awesome.user.mapperInterface;

import com.prj.web.awesome.user.dto.HeartDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HeartMapper {
    @Select("select * from heart where user_id=#{user_id}")
    List<HeartDTO> findList(String user_id);

    @Insert("insert into heart (user_id, item_id) values (#{user_id}, #{item_id})")
    void save(HeartDTO heartDTO);

    @Delete("delete from heart where item_id=#{item_id}")
    void delete(int item_id);

}