package com.prj.web.awesome.user.mapperInterface;

import com.prj.web.awesome.community.criTest.Criteria;
import com.prj.web.awesome.community.criTest.SearchCriteria;
import com.prj.web.awesome.order.dto.OrderDetailDTO;
import com.prj.web.awesome.order.dto.OrderListDTO;
import com.prj.web.awesome.user.dto.AddrDTO;
import com.prj.web.awesome.user.dto.CouponDTO;
import com.prj.web.awesome.user.dto.CouponInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MyPageMapper {

    // addrList
    List<AddrDTO> addrList(String user_id);

    // addrSelectOne : Detail
    AddrDTO addrSelectOne(AddrDTO dto);

    // addrInsert
    int addrInsert(AddrDTO dto);

    // 주소 추가시 기본배송지 update
    int insertAddrUpdate(AddrDTO dto);

    // update
    int addrUpdate(AddrDTO dto);

    @Select("select * from addr where user_id=#{user_id} and addr_default='Y'")
    AddrDTO findAddr(String user_id);

    // addrDelete
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

//    @Select("select * from order_list where user_id=#{user_id}")
    @Select("SELECT o.order_date, i.item_name, o.order_price, o.order_payment, o.order_status, o.order_claim " +
            "FROM order_list o JOIN order_detail d ON o.order_code = d.order_code " +
            "JOIN item i ON d.item_id = i.item_id"
    )
    List<OrderListDTO> orderList(String user_id);


    List<OrderListDTO> searchList(SearchCriteria cri);
    int searchTotalCount(SearchCriteria cri);

    // ** Criteria PageList
    List<OrderListDTO> criList(Criteria cri);
    int criTotalCount();



    @Select("SELECT * from order_detail d " +
            "JOIN order_list o ON o.order_code = d.order_code " +
            "JOIN item i ON d.item_id = i.item_id " +
            "WHERE d.order_code=#{order_code}"
    )
    List<OrderDetailDTO> orderDetail(int order_code);

}
