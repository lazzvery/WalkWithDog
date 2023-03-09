package com.prj.web.awesome.order.mapper;

import com.prj.web.awesome.order.dto.CouponJoinInfoDTO;
import com.prj.web.awesome.order.dto.OrderDetailDTO;
import com.prj.web.awesome.order.dto.OrderDetailItemDTO;
import com.prj.web.awesome.user.dto.AddrDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderDetailMapper {
    @Select("SELECT od.order_detail_code, od.order_code, i.item_id, i.item_name, od.item_price, od.item_count " +
            "FROM order_detail od " +
            "JOIN item i ON od.item_id = i.item_id " +
            "WHERE od.order_code=#{order_code}")
    List<OrderDetailItemDTO> findOrderList(int order_code);

    @Select("SELECT c.coupon_seq, c.coupon_quantity, c.user_id, ci.coupon_code, ci.coupon_name, ci.coupon_buy, ci.coupon_benefits " +
            "FROM coupon c " +
            "JOIN coupon_info ci ON c.coupon_code = ci.coupon_code " +
            "WHERE c.user_id=#{user_id}")
    List<CouponJoinInfoDTO> findCouponList(String user_id);

    void saveCart(OrderDetailDTO orderDetailDTO);
}
