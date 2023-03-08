package com.prj.web.awesome.user.mapperInterface;

import com.prj.web.awesome.user.dto.AddrDTO;
import com.prj.web.awesome.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    AddrDTO findAddr(@Param("itemId") int itemId, @Param("addrSeq") List<Integer> addrSeq);

    // 5. delete
    int addrDelete(int addr_seq);
}
