package com.prj.web.awesome.user.mapperInterface;

import com.prj.web.awesome.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
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
//
//    // 5. delete
//    @Delete("delete from member where id=#{id}")
//    int delete(UserDTO vo);
}
