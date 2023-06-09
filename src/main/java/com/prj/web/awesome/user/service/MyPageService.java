package com.prj.web.awesome.user.service;

import com.prj.web.awesome.community.criTest.Criteria;
import com.prj.web.awesome.community.criTest.SearchCriteria;
import com.prj.web.awesome.order.dto.OrderDetailDTO;
import com.prj.web.awesome.order.dto.OrderListDTO;
import com.prj.web.awesome.user.dto.AddrDTO;
import com.prj.web.awesome.user.dto.CouponDTO;
import com.prj.web.awesome.user.dto.CouponInfoDTO;
import com.prj.web.awesome.user.mapperInterface.MyPageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyPageService {

    @Autowired
    MyPageMapper mapper;

    // selectList ( 사용자 id별 배송지 리스트 )
    public List<AddrDTO> addrList(String user_id){
        return mapper.addrList(user_id);
    }

    // selectOne : Detail
    public AddrDTO addrSelectOne(AddrDTO dto){
        return mapper.addrSelectOne(dto);
    }

    // insert
    public int addrInsert(AddrDTO dto){
        return mapper.addrInsert(dto);
    }

    // 배송지 추가 했을때 기본배송지 설정시 기존 기본배송지 n으로 update
    public int insertAddrUpdate(AddrDTO dto) { return mapper.insertAddrUpdate(dto);}

    // 배송지 update
    public int addrUpdate(AddrDTO dto) { return mapper.addrUpdate(dto);}

    public AddrDTO findAddr(String user_id) {
        return mapper.findAddr(user_id);
    }

    // 5. delete
    public int addrDelete(int addr_seq){
        return mapper.addrDelete(addr_seq);
    };

    // coupon 조회
    public List<CouponDTO> findCoupon(String user_id) {
        return mapper.findCoupon(user_id);
    }

    // coupon info 조회
    public CouponInfoDTO findOneCoupon(String coupon_code) {
        return mapper.findOneCoupon(coupon_code);
    }

    // 쿠폰 수량 업데이트
    public void updateCouponQuantity(String coupon_code) {
        mapper.updateCouponQuantity(coupon_code);
    }

    // orderList ( 사용자 id별 상품 리스트 )
    public List<OrderListDTO> orderList(String user_id){
        return mapper.orderList(user_id);
    }

    // ** SearchCriteria PageList
    public List<OrderListDTO> searchList(SearchCriteria cri){
        return mapper.searchList(cri);
    }

    public int searchTotalCount(SearchCriteria cri){
        return mapper.searchTotalCount(cri);
    }

    // ** Criteria PageList
    public List<OrderListDTO> criList(Criteria cri){
        return mapper.criList(cri);
    }



    public List<OrderDetailDTO> orderDetail(int order_code){ return mapper.orderDetail(order_code);}

}
