package com.prj.web.awesome.user.mapperInterface;

import com.prj.web.awesome.user.dto.AddrDTO;
import com.prj.web.awesome.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MyPageMapper {

    // 1. addrList
    List<AddrDTO> addrList(String user_id);
//    AddrDTO addrList(AddrDTO dto);
//
    // 2. selectOne : Detail
    UserDTO addrSelectOne(AddrDTO dto);


    // 3. insert
    int addrInsert(AddrDTO dto);

    // 4. update
    int insertAddrUpdate(AddrDTO dto);

    @Select("select * from addr where user_id=#{user_id} and addr_default='Y'")
    AddrDTO findAddr(String user_id);

    // 5. delete
    int addrDelete(int addr_seq);
}
