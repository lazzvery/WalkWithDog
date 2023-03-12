package com.prj.web.admin.upload.service;

import com.prj.web.admin.upload.dto.ImageDTO;
import com.prj.web.awesome.item.dto.ItemDto;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ImageService {
    void saveFile(ImageDTO imageDTO);
    void saveItem(ItemDto itemDto);
    int selectLastInsertId();
    String findMainImg(int item_id);
    List<String> findSubImg(int item_id);
}
