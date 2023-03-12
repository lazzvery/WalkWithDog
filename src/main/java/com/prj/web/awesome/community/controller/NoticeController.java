package com.prj.web.awesome.community.controller;

import com.prj.web.awesome.community.dto.NoticeDTO;
import com.prj.web.awesome.community.dto.ReviewDTO;
import com.prj.web.awesome.community.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping(value = "/community")
@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/notice")
    public String notice(Model model){

        List<NoticeDTO> noticeList = noticeService.noticeList();

        model.addAttribute("noticeList", noticeList);

        return "html/community/notice/communityNotice";
    }

    @GetMapping("/noticeDetail")
    public String noticeDetail(Model model, NoticeDTO dto){

        NoticeDTO noticeDetail = noticeService.noticeDetail(dto);

        model.addAttribute("noticeDetail", noticeDetail);

        return "html/community/notice/communityNoticeDetail";
    }

    @GetMapping("/noticeInsert")
    public String noticeInsertForm(Model model){

        model.addAttribute("noticeInsert", new NoticeDTO());

        return "html/community/notice/communityNoticeWrite";
    }

    @PostMapping("/noticeInsert")
    public String noticeInsert(NoticeDTO dto, HttpServletRequest request){

        NoticeDTO noticeDTO = new NoticeDTO();
        noticeDTO.setNotice_seq(dto.getNotice_seq());
        noticeDTO.setNotice_title(dto.getNotice_title());
        noticeDTO.setNotice_content(dto.getNotice_content());
        noticeDTO.setNotice_reg_date(dto.getNotice_reg_date());
        noticeDTO.setAttachment_file_seq(dto.getAttachment_file_seq());

//        String realPath = request.getRealPath("/");
//        System.out.println(realPath);
//
//        // 2) 위 의 값을 이용해서 실제저장위치 확인
//        // => 개발중인지, 배포했는지 에 따라 결정
//        if ( realPath.contains(".intellij.") )  // 개발중 (배포전: eclipse 개발환경)
//            realPath = "/Volumes/Macintosh HD - 데이터/finalproject/src/main/resource/static/img/community/review/" ;
//        else realPath += "resources/static/img/community/review/";
//
//        // ** 폴더 만들기 (File 클래스활용)
//        // => 위의 저장경로에 폴더가 없는 경우 (uploadImage가 없는경우)  만들어 준다
//        File f1 = new File(realPath);
//        if ( !f1.exists() )  f1.mkdir();
//        // => realPath 디렉터리가 존재하는지 검사 (uploadImage 폴더 존재 확인)
//        //    존재하지 않으면 디렉토리 생성
//
//        // ** 기본 이미지 지정하기
//        String  file1, file2="resources/uploadImage/basicman4.png" ;

        // ** MultipartFile
        // => 업로드한 파일에 대한 모든 정보를 가지고 있으며 이의 처리를 위한 메서드를 제공한다.
        //    -> String getOriginalFilename(),
        //    -> void transferTo(File destFile),
        //    -> boolean isEmpty()

//        MultipartFile uploadfilef = dto.getUploadfilef(); // file 의 내용및 화일명 등 전송된 정보들
//        if ( uploadfilef!=null && !uploadfilef.isEmpty() ) {
//            // ** Image를 선택함 -> Image저장 ( 경로_realPath + 화일명 )
//            // 1) 물리적 저장경로(file1) 에 Image 저장
//            file1= realPath + uploadfilef.getOriginalFilename(); // 저장경로 완성
//            uploadfilef.transferTo(new File(file1));
//
//            // 2) Table 저장 (file2) 준비
//            file2="resources/uploadImage/" + uploadfilef.getOriginalFilename();
//        }

        noticeService.noticeInsert(noticeDTO);

        System.out.println(noticeDTO);
        return "redirect:notice";

    }

    @GetMapping("/noticeUpdate")
    public String noticeUpdateForm(Model model, NoticeDTO dto){

        System.out.println("d1" +dto);

        NoticeDTO noticeDetail = noticeService.noticeDetail(dto);

        model.addAttribute("noticeDetail", noticeDetail);

        System.out.println("d2" +noticeDetail);

        return "html/community/notice/communityNoticeUpdate";
    }
    @PostMapping ("/noticeUpdate")
    public String reviewUpdate(Model model, NoticeDTO dto){

        String url = "redirect:notice";

        if (noticeService.noticeUpdate(dto) <= 0){
            url = "redirect:noticeUpdate?notice_seq=" + dto.getNotice_seq();
        }

        return url;
    }

    @GetMapping("/noticeDelete")
    public String noticeDelete(NoticeDTO dto){

        noticeService.noticeDelete(dto);

        return "redirect:/community/notice";

    }
}
