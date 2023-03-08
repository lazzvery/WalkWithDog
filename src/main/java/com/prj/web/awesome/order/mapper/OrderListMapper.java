package com.prj.web.awesome.order.mapper;

import com.prj.web.awesome.order.dto.OrderListDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderListMapper {
    @Select("select * from order_list where order_code=#{order_code}")
    OrderListDTO findById(int order_code);

    @Insert("insert into order_list (order_date, order_status, user_id) " +
            "values (NOW(), 'R', #{user_id})")
    void createOrderList(String user_id);
}
