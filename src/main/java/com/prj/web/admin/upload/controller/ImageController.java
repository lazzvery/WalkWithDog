package com.prj.web.admin.upload.controller;

import com.prj.web.admin.upload.dto.ImageDTO;
import com.prj.web.admin.upload.dto.ItemFormDTO;
import com.prj.web.admin.upload.file.FileStore;
import com.prj.web.admin.upload.service.ImageService;
import com.prj.web.awesome.category.dto.CategoryDTO;
import com.prj.web.awesome.category.service.CategoryService;
import com.prj.web.awesome.item.dto.ItemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;
    private final CategoryService categoryService;
    private final FileStore fileStore;

    @GetMapping("/image/upload")
    public String newItem(Model model) {
        List<CategoryDTO> category = categoryService.categoryList();

        log.info("category={}", category);
        model.addAttribute("category", category);

        return "html/admin/item/imageInsert";
    }

    @PostMapping("/image/upload")
    public String saveItem(ItemFormDTO itemFormDTO, ItemDto itemDto) throws IOException {
        String mainName = fileStore.storeFile(itemFormDTO.getMainImage());
        List<String> subName = fileStore.storeFiles(itemFormDTO.getSubImages());
        List<String> infoName = fileStore.storeFiles(itemFormDTO.getInfoImages());

        imageService.saveItem(itemDto);
        int item_id = imageService.selectLastInsertId();
        log.info("item_id={}", item_id);

        saveImages(mainName, "m", item_id);   // 메인 저장
        for (String sub : subName) {      // 서브 저장
            saveImages(sub , "s", item_id);
        }
        for (String info : infoName) {
            saveImages(info, "i", item_id);
        }

        return "/index";
    }

    private void saveImages(String name, String flag, int item_id) {
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setImg_div_flag(flag);
        imageDTO.setImg_name(name);
        imageDTO.setItem_id(item_id);
        imageService.saveFile(imageDTO);
    }

}
