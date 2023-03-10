package com.prj.web.awesome.order.mapper;

import com.prj.web.awesome.order.dto.CouponJoinInfoDTO;
import com.prj.web.awesome.order.dto.OrderDetailDTO;
import com.prj.web.awesome.order.dto.OrderDetailItemDTO;
import com.prj.web.awesome.order.dto.OrderListDTO;
import com.prj.web.awesome.user.dto.AddrDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderDetailMapper {
    @Select("select * from order_list where order_code=#{order_code}")
    OrderListDTO findOrderList(int order_code);

    @Select("SELECT c.coupon_seq, c.coupon_quantity, c.user_id, ci.coupon_code, ci.coupon_name, ci.coupon_buy, ci.coupon_benefits " +
            "FROM coupon c " +
            "JOIN coupon_info ci ON c.coupon_code = ci.coupon_code " +
            "WHERE c.user_id=#{user_id}")
    List<CouponJoinInfoDTO> findCouponList(String user_id);

    void saveCart(OrderDetailDTO orderDetailDTO);
}
