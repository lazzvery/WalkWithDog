package com.prj.web.admin.user.service;

import com.prj.web.admin.user.mapperInterface.AdminMyPageMapper;
import com.prj.web.awesome.user.dto.AddrDTO;
import com.prj.web.awesome.user.dto.CouponDTO;
import com.prj.web.awesome.user.mapperInterface.MyPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminMyPageService {

    @Autowired
    MyPageMapper mapper;
    @Autowired
    AdminMyPageMapper amapper;

    //1. selectList
    public List<AddrDTO> addrList(){
        List<AddrDTO> addrList = new ArrayList<AddrDTO>();

        try {
            addrList = amapper.addrList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return addrList;
    }

    public List<CouponDTO> couponList(){
        List<CouponDTO> couponList = new ArrayList<CouponDTO>();

        try {
            couponList = amapper.couponList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return couponList;
    }

//    public AddrDTO addrList(AddrDTO dto){
//        return mapper.addrList(dto);
//    }
//
//    // 2. selectOne : Detail
//    public UserDTO userSelectOne(UserDTO dto){
//        return mapper.userSelectOne(dto);
//    }

    // 3. insert
    public int addrInsert(AddrDTO dto){
        return mapper.addrInsert(dto);
    };
//
//    // 4. update
//    public int userUpdate(UserDTO dto) { return mapper.userUpdate(dto);};
////
////    // 5. delete
//    public int userDelete(UserDTO dto){
//        return mapper.userDelete(dto);
//    };

}
