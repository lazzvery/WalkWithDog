package com.prj.web.awesome.item.service;

import com.prj.web.awesome.item.dto.ItemQnaDTO;
import com.prj.web.awesome.item.mapper.ItemQnaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemQnaServiceImpl implements ItemQnaService {

    private final ItemQnaMapper mapper;

    @Override
    public List<ItemQnaDTO> findAll(int item_id) {
        return mapper.findAll(item_id);
    }

    @Override
    public ItemQnaDTO findById(int item_qna_seq) {
        return mapper.findById(item_qna_seq);
    }

    @Override
    public void save(ItemQnaDTO itemQnaDTO) {
        mapper.save(itemQnaDTO);
    }
}
