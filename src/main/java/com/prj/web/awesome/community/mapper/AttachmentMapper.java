package com.prj.web.awesome.community.mapper;

import com.prj.web.awesome.community.dto.AttachmentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AttachmentMapper {

    List<AttachmentDTO> attachmentList() throws Exception;

    void attachmentInsert(AttachmentDTO dto);


}
