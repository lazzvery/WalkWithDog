package com.prj.web.awesome.item.mapper;

import com.prj.web.awesome.item.dto.ItemQnaDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ItemQnaMapper {
    @Select("select * from item_qna where item_id=#{item_id}")
    List<ItemQnaDTO> findAll(int item_id);

    @Select("select * from item_qna where item_qna_seq=#{item_qna_seq}")
    ItemQnaDTO findById(int item_qna_seq);
}
