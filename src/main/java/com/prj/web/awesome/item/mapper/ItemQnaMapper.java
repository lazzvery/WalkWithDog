package com.prj.web.awesome.item.mapper;

import com.prj.web.awesome.item.dto.ItemQnaDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ItemQnaMapper {
    @Select("select * from item_qna where item_id=#{item_id} order by item_qna_pnum desc")
    List<ItemQnaDTO> findAll(int item_id);

    @Select("select * from item_qna where item_qna_seq=#{item_qna_seq}")
    ItemQnaDTO findById(int item_qna_seq);

    void save(ItemQnaDTO itemQnaDTO);

    @Update("update item_qna set item_qna_title=#{item_qna_title}, item_qna_content=#{item_qna_content} where item_qna_seq=#{item_qna_seq}")
    void update(ItemQnaDTO itemQnaDTO);

    @Delete("delete from item_qna where item_qna_seq=#{item_qna_seq}")
    void delete(int item_qna_seq);


}
