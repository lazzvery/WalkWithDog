package com.prj.web.awesome.user.service;

import com.prj.web.awesome.user.dto.CartDTO;
import com.prj.web.awesome.user.dto.CartItemDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CartService {
    List<CartItemDTO> findCartItem(String user_id);
    CartDTO findCart(int itemId, String userId);
    void saveCart(CartDTO cartDTO);
    void deleteCart(int item_id);
}
