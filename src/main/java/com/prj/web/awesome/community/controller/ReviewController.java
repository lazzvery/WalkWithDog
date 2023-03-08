package com.prj.web.awesome.community.controller;

import com.prj.web.awesome.community.criTest.PageNation;
import com.prj.web.awesome.community.criTest.SearchCriteria;
import com.prj.web.awesome.community.dto.FaqDTO;
import com.prj.web.awesome.community.dto.NoticeDTO;
import com.prj.web.awesome.community.dto.QnaDTO;
import com.prj.web.awesome.community.dto.ReviewDTO;
import com.prj.web.awesome.community.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URI;
import java.util.List;

@RequestMapping(value = "/community")
@Controller
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/review")
    public ModelAndView review(ModelAndView mv, SearchCriteria cri, PageNation pageNation){

        cri.setSnoEno();

        mv.addObject("reviewList", reviewService.searchList(cri));

        pageNation.setCriteria(cri);
        pageNation.setTotalRowsCount(reviewService.searchTotalCount(cri));
        mv.addObject("pageNation", pageNation);

        mv.setViewName("html/community/review/communityReview");

        return mv;

    }

    @GetMapping("/reviewDetail")
    public String reviewDetail(Model model, ReviewDTO dto){

        ReviewDTO reviewDetail = reviewService.reviewDetail(dto);

        model.addAttribute("reviewDetail", reviewDetail);

        return "html/community/review/communityReviewDetail";

    }
@GetMapping("/reviewInsert")
public String reviewInsertForm(Model model){

    model.addAttribute("reviewInsert", new ReviewDTO());

    return "html/community/review/communityReviewWrite";
}

    @PostMapping("/reviewInsert")
    public String reviewInsert(ReviewDTO dto,HttpServletRequest request){

        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setReview_seq(dto.getReview_seq());
        reviewDTO.setItem_id(dto.getItem_id());
        reviewDTO.setUser_id((String) request.getSession().getAttribute("loginID"));
        reviewDTO.setReview_title(dto.getReview_title());
        reviewDTO.setReview_content(dto.getReview_content());
        reviewDTO.setReview_reg_date(dto.getReview_reg_date());
        reviewDTO.setReview_rank(dto.getReview_rank());
        reviewDTO.setReview_attachment1(dto.getReview_attachment1());
        reviewDTO.setReview_attachment2(dto.getReview_attachment2());
        reviewDTO.setReview_attachment3(dto.getReview_attachment3());

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

        reviewService.reviewInsert(reviewDTO);

        System.out.println(reviewDTO);
        return "redirect:review";

    }

    @GetMapping("/reviewUpdate")
    public String reviewUpdateForm(Model model, ReviewDTO dto){

        System.out.println("d1" +dto);

        ReviewDTO reviewDetail = reviewService.reviewDetail(dto);

        model.addAttribute("reviewDetail", reviewDetail);

        System.out.println("d2" +reviewDetail);

        return "html/community/review/communityReviewUpdate";
    }
    @PostMapping ("/reviewUpdate")
    public String reviewUpdate(Model model, ReviewDTO dto){

        String url = "redirect:review";

        if (reviewService.reviewUpdate(dto) <= 0){
            url = "redirect:reviewUpdate?review_seq=" + dto.getReview_seq();
        }

        return url;
    }

    @GetMapping("/reviewDelete")
    public String reviewDelete(ReviewDTO dto){

        reviewService.reviewDelete(dto);

        return "redirect:/community/review";

    }
}
