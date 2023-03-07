package com.prj.web.admin.user.mapperInterface;

import com.prj.web.awesome.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminUserMapper {

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

}
