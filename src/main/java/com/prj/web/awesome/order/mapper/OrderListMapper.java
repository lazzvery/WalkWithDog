package com.prj.web.awesome.order.mapper;

import com.prj.web.awesome.order.dto.OrderListDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderListMapper {
    @Select("select * from order_list ORDER BY order_code DESC LIMIT 1")
    OrderListDTO findById();

    @Insert("insert into order_list (order_date, order_price, order_payment, order_status, user_id, coupon_code, addr_seq) " +
            "values (NOW(), #{order_price}, #{order_payment}, 'R', #{user_id}, #{coupon_code}, #{addr_seq})")
    void createOrderList(OrderListDTO orderListDTO);
}
