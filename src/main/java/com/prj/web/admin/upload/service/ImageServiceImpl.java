package com.prj.web.admin.upload.service;

import com.prj.web.admin.upload.dto.ImageDTO;
import com.prj.web.admin.upload.mapper.ImageMapper;
import com.prj.web.awesome.item.dto.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageMapper mapper;

    @Override
    public void saveFile(ImageDTO imageDTO) {
        mapper.saveFile(imageDTO);
    }

    @Override
    public void saveItem(ItemDto itemDto) {
        mapper.saveItem(itemDto);
    }

    @Override
    public int selectLastInsertId() {
        return mapper.selectLastInsertId();
    }

    @Override
    public String findMainImg(int item_id) {
        return mapper.findMainImg(item_id);
    }

    @Override
    public List<String> findSubImg(int item_id) {
        return mapper.findSubImg(item_id);
    }

    @Override
    public List<String> findInfoImg(int item_id) {
        return mapper.findInfoImg(item_id);
    }
}
