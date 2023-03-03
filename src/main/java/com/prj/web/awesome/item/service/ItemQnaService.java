package com.prj.web.awesome.item.service;

import com.prj.web.awesome.item.dto.ItemQnaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ItemQnaService {
    List<ItemQnaDTO> findAll(int item_id);
    ItemQnaDTO findById(int item_qna_seq);
    void save(ItemQnaDTO itemQnaDTO);
    void update(ItemQnaDTO itemQnaDTO);
    void delete(int item_qna_seq);
}
