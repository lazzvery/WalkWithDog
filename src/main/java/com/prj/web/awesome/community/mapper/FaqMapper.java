package com.prj.web.awesome.community.mapper;

import com.prj.web.awesome.community.dto.FaqDTO;
import com.prj.web.awesome.community.dto.QnaDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FaqMapper {

    List<FaqDTO> faqList() throws Exception;

    void faqInsert(FaqDTO dto);

    int faqUpdate(FaqDTO dto);

    void faqDelete(FaqDTO dto);

}
