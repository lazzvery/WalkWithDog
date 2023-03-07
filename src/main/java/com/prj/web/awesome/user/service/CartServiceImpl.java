package com.prj.web.awesome.user.service;

import com.prj.web.awesome.user.dto.CartDTO;
import com.prj.web.awesome.user.dto.CartItemDTO;
import com.prj.web.awesome.user.mapperInterface.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartMapper mapper;

    @Override
    public List<CartItemDTO> findCartItem(String user_id) {
        return mapper.findCartItem(user_id);
    }

    @Override
    public CartDTO findCart(int itemId, String userId) {
        return mapper.findCart(itemId, userId);
    }

    @Override
    public void saveCart(CartDTO cartDTO) {
        mapper.saveCart(cartDTO);
    }

    @Override
    public void deleteCart(int item_id) {
        mapper.deleteCart(item_id);
    }
}
