package com.prj.web.awesome.user.mapperInterface;

import com.prj.web.awesome.user.dto.AddrDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MyPageMapper {

    // 1. addrList
    List<AddrDTO> addrList(String user_id);
//    AddrDTO addrList(AddrDTO dto);
//
//    // 2. selectOne : Detail
//    UserDTO userSelectOne(UserDTO dto);


    // 3. insert
    int addrInsert(AddrDTO dto);

//    // 4. update
//    int userUpdate(UserDTO dto);
//
//    // 5. delete
//    int userDelete(UserDTO dto);
}
