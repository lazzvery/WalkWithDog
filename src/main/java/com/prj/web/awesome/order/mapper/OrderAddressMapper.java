package com.prj.web.awesome.order.mapper;

import com.prj.web.awesome.user.dto.AddrDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderAddressMapper {
    @Update("update addr set addr_default='Y' where addr_seq=#{addr_seq}")
    int addrUpdate(AddrDTO dto);
}
