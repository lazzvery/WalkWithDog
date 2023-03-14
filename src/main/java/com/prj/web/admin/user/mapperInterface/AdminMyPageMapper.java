package com.prj.web.admin.user.mapperInterface;

import com.prj.web.awesome.user.dto.AddrDTO;
import com.prj.web.awesome.user.dto.CouponDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminMyPageMapper {

    // 1. addrList
    List<AddrDTO> addrList() throws Exception;
    List<CouponDTO> couponList() throws Exception;
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
