package com.prj.web.awesome.order.mapper;

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
    @Select("SELECT od.order_detail_code, od.order_code, i.item_name, od.item_price, od.item_count " +
            "FROM order_detail od " +
            "JOIN item i ON od.item_id = i.item_id " +
            "WHERE od.order_code=#{order_code}")
    List<OrderDetailItemDTO> findOrderList(int order_code);

    void saveCart(OrderDetailDTO orderDetailDTO);
}
