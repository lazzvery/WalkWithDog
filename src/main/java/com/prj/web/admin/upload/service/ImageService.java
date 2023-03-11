package com.prj.web.admin.upload.service;

import com.prj.web.admin.upload.dto.ImageDTO;
import com.prj.web.awesome.item.dto.ItemDto;

public interface ImageService {
    void saveFile(ImageDTO imageDTO);
    void saveItem(ItemDto itemDto);
    int selectLastInsertId();
}
