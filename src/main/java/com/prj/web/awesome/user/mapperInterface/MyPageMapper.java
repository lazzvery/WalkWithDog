package com.prj.web.awesome.user.mapperInterface;

import com.prj.web.awesome.user.dto.AddrDTO;
import com.prj.web.awesome.user.dto.CouponDTO;
import com.prj.web.awesome.user.dto.CouponInfoDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
    AddrDTO addrSelectOne(AddrDTO dto);

    // 3. insert
    int addrInsert(AddrDTO dto);

    // 4. 주소 추가시 기본배송지 update
    int insertAddrUpdate(AddrDTO dto);

    // update
    int addrUpdate(AddrDTO dto);

    @Select("select * from addr where user_id=#{user_id} and addr_default='Y'")
    AddrDTO findAddr(String user_id);

    // 5. delete
    int addrDelete(int addr_seq);

    // coupon 조회
    @Select("select * from coupon where user_id=#{user_id}")
    List<CouponDTO> findCoupon(String user_id);

    // coupon info 조회
    @Select("select * from coupon_info where coupon_code=#{coupon_code}")
    CouponInfoDTO findOneCoupon(String coupon_code);

    // 쿠폰 수량 업데이트
    @Update("update coupon set coupon_quantity = coupon_quantity - 1 where coupon_code=#{coupon_code}")
    void updateCouponQuantity(String coupon_code);
}
