package com.prj.web.awesome.order.service;

import com.prj.web.awesome.order.mapper.OrderAddressMapper;
import com.prj.web.awesome.user.dto.AddrDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderAddressService {

    @Autowired
    OrderAddressMapper mapper;

    public int addrUpdate(AddrDTO dto){
        return mapper.addrUpdate(dto);
    };
}
