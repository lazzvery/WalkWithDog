package com.prj.web.awesome.user.mapperInterface;

import com.prj.web.awesome.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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


    @Select("select user_id from user WHERE user_phone=#{user_phone} AND user_name=#{user_name}")
    String findId(@Param("user_name") String name, @Param("user_phone") String phone);

    @Select("select * from user WHERE user_phone=#{user_phone} AND user_name=#{user_name} AND user_id=#{user_id}")
    String findPw(@Param("user_name") String name, @Param("user_phone") String phone, @Param("user_id") String id);

    @Update("update user set user_password=#{user_password} where user_id=#{user_id}")
    int findPwUpdate(UserDTO dto);

}
