package com.prj.web.awesome.user.mapperInterface;

import com.prj.web.awesome.user.dto.HeartDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HeartMapper {
    @Select("select * from heart where user_id=#{user_id}")
    List<HeartDTO> findList(String user_id);
}