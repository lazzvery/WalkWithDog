package com.prj.web.awesome.user.mapperInterface;

import com.prj.web.awesome.user.dto.CartDTO;
import com.prj.web.awesome.user.dto.CartItemDTO;
import com.prj.web.awesome.user.dto.HeartDTO;
import com.prj.web.awesome.user.dto.HeartItemDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CartMapper {

    @Select("SELECT c.cart_code, c.cart_amount, c.user_id, i.item_name, i.item_price, i.item_id " +
            "FROM cart c JOIN item i ON c.item_id = i.item_id " +
            "WHERE c.user_id=#{user_id}")
    List<CartItemDTO> findCartItem(String user_id);

    @Select("select * from cart where item_id=#{itemId} and user_id=#{userId}")
    CartDTO findCart(@Param("itemId") int itemId, @Param("userId") String userId);

    @Insert("insert into cart (cart_amount, user_id, item_id) " +
            "values (#{cart_amount}, #{user_id}, #{item_id})")
    void saveCart(CartDTO cartDTO);

    @Delete("delete from cart where item_id=#{item_id}")
    void deleteCart(int item_id);

}