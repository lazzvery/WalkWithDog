package com.prj.web.admin.upload.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FileStore {

    @Value("${file.dir}")
    private String fileDir;

    public String getFullPath(String filename) {
        return fileDir + filename;
    }   // 최종 이미지 경로

    public List<String> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
        List<String> storeFileResult = new ArrayList<>();

        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFile.isEmpty()) {
                storeFileResult.add(storeFile(multipartFile));  // 꺼내서 storeFile()로 하나씩 처리
            }
        }
        return storeFileResult;
    }   // 여러건 첨부파일 처리

    public String storeFile(MultipartFile multipartFile) throws IOException {
        if(multipartFile.isEmpty()) {
            return null;
        }

        String originalFilename = multipartFile.getOriginalFilename();  // 기존 파일 이름 꺼내기
        String storeFileName = createStoreFileName(originalFilename);   // 겹치지 않게 하기 위해서 random으로 uuid 만든 후 원래 파일 확장자만 붙이기
        multipartFile.transferTo(new File(getFullPath(storeFileName)));     // 파일 저장 (안에는 저장 경로 + 저장할 파일명.확장자)
        return storeFileName; // 서버에 저장될 파일명을 리턴

    }   // 단건 첨부파일 처리

    /**
     * 파일 확장자를 위한 메서드
     */
    private String createStoreFileName(String originalFilename) {
        String uuid = UUID.randomUUID().toString();
        String ext = extractExt(originalFilename);
        return uuid + "." + ext;
    }

    private String extractExt(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }

}
