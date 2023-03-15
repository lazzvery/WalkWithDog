package com.prj.web.awesome.user.mapperInterface;

import com.prj.web.awesome.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    // 1. selectList
    List<UserDTO> selectList() throws Exception;

    // 2. selectOne : Detail
    UserDTO userSelectOne(UserDTO dto);


    // 3. insert
    int userInsert(UserDTO vo);

    // 4. update
    int userUpdate(UserDTO dto);

    // 5. delete
    int userDelete(UserDTO dto);


    @Select("select user_id from user where (user_email=#{user_email} or user_phone=#{user_phone}) and user_name=#{user_name}")
    public String findId(@Param("user_name") String name, @Param("user_email") String email, @Param("user_phone") String phone);

}
