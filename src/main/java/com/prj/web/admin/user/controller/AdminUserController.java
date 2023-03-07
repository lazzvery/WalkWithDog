package com.prj.web.admin.user.controller;

import com.prj.web.awesome.user.dto.UserDTO;
import com.prj.web.awesome.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminUserController {

    @Autowired
    UserService service;

    // 관리자 페이지 홈
    @GetMapping("/home")
    public String home(Model model) {

        return "html/admin/admin";
    } //ulist

    // 유저 리스트
    @GetMapping("/user/userInfo")
    public String ulist(Model model) {

        List<UserDTO> selectList = service.selectList();

        model.addAttribute("selectList", selectList);

        return "html/admin/user/userInfo";
    } //ulist


    @GetMapping("/user/userDetail")
    public ModelAndView detail(HttpServletRequest request, ModelAndView mv, UserDTO dto) {

        // => 처리순서 : parameter확인: 없으면 -> session 확인 -> Update요청여부 확인
        if ( dto.getUser_id()==null || dto.getUser_id().length()<1 ) {
            // => session 확인
            if ( request.getSession().getAttribute("loginID")!=null ) {
                dto.setUser_id((String)request.getSession().getAttribute("loginID"));
            }
        } // vo확인

        // 2) Service
        dto=service.userSelectOne(dto);
        mv.addObject("userInfo", dto);

        System.out.println(dto);
        System.out.println(dto.getUser_id());

        mv.setViewName("html/admin/user/userDetail");



        return mv;
    } //detail
//
//
//    // ** Login & Logout **
//    @GetMapping("/login")
//    public String loginF() {
//        return "/html/user/userLogin";
//    } //loginF
//
//    @PostMapping(value="/login")
//    public ModelAndView login(HttpServletRequest request, ModelAndView mv, UserDTO dto) {
//        // 1) 요청분석
//        String password=dto.getUser_password();
//
//        // 2) Service 실행
//        // => 성공 -> 로그인정보 보관후, home
//        // => 실패 -> loginForm 재로그인 유도
//        String uri="/html/user/userLogin" ;
//        dto=service.userSelectOne(dto);
//
//
//        if ( dto!=null ) {
//            // -> Password 확인 : 암호화 이후
////            if ( passwordEncoder.matches(password, dto.getPassword()) ) {
//
//            // ** id 일치 -> Password 확인 : 암호화 이전
//            if (dto.getUser_password().equals(password)) {
//                // 로그인 성공 -> session 에 로그인정보 보관
//                request.getSession().setAttribute("loginID", dto.getUser_id());
//                request.getSession().setAttribute("loginName", dto.getUser_name());
//                uri="redirect:/"; // * 주의 : 반드시 요청명사용
//            }else {
//                // password 오류
//                mv.addObject("message", "~~ password 오류 !! 다시 하세요 ~~");
//            }
//        }else { // id 오류
//            mv.addObject("message", "~~ ID 오류 !! 다시 하세요 ~~");
//        }
//        // 3) View 처리
//        mv.setViewName(uri);
//        return mv;
//    } //login
//
//
//
//    // 회원가입
//    @GetMapping("/join")
//    public String userInsertForm(){
//        return "/html/user/userJoin";
//    }
//
//    @PostMapping("/join")
//    public String userInsert(UserDTO dto){
//
//        UserDTO userInfo = new UserDTO();
//        userInfo.setUser_id(dto.getUser_id());
//        userInfo.setUser_password(dto.getUser_password());
//        userInfo.setUser_name(dto.getUser_name());
//        userInfo.setUser_email(dto.getUser_email());
//        userInfo.setUser_email_check(dto.getUser_email_check());
//        userInfo.setUser_phone(dto.getUser_phone());
//        userInfo.setUser_sns_check(dto.getUser_sns_check());
//        userInfo.setUser_birthday(dto.getUser_birthday());
//        userInfo.setUser_gen(dto.getUser_gen());
//
//
//        service.userInsert(userInfo);
//
//        return "redirect:/";
//    }
//
//
//    // ** user Update **
//    @GetMapping("/myPage/modify")
//    public String UserUpdatef(Model mv , UserDTO dto, HttpServletRequest request) throws IOException{
//        dto.setUser_id((String)request.getSession().getAttribute("loginID"));
//
//        dto = service.userSelectOne(dto);
//        mv.addAttribute("userinfo", dto);
//
//        System.out.println(dto);
//
//        return "html/user/myPage/userMyPageModify";
//    }
//    @PostMapping("/myPage/modify")
//    public ModelAndView UserUpdate(HttpServletRequest request, ModelAndView mv, UserDTO dto) throws IOException{
//
//        // 2) Service 실행
//        // => 성공 -> 내정보 표시, memberDetail
//        // => 실패 -> 친절하게 안내하고 재수정 유도, updateForm
//        String uri="html/user/myPage/userMyPageHome" ;
//
//        // => Update 성공/실패 모두 출력시 필요하므로
//
//        mv.addObject("userInfo", dto);
//
//
//        if ( service.userUpdate(dto)>0 ) {
//            mv.addObject("message", "~~ 회원정보 수정 성공 ~~");
//        }else {
//            uri="html/user/myPage/userMyPageModify" ;
//            mv.addObject("message", "~~ 회원정보 수정 실패, 다시 하세요 ~~");
//        }
//        // 3) View 처리
//        mv.setViewName(uri);
//
//        return mv;
//    } //update
//
//
//    // ** Member Delete **
//
//    @GetMapping("/delete")
//    public ModelAndView userDelete(HttpServletRequest request, ModelAndView mv, UserDTO dto) {
//        // 1) 요청분석
//        // 1.1) login 정보: session 에서 loginID 를 get
//        // 1.2) 관리자 기능: loginID=='admin' and Parameter id 가 존재하는경우
//
//        dto.setUser_id((String)request.getSession().getAttribute("loginID"));
//
//        // 2) Service 실행
//        // => 성공
//        //	-> 본인탈퇴: 반드시 session 처리 해야함
//        service.userDelete(dto);
//        request.getSession().invalidate();
//
//        // 3) View 처리
//        mv.setViewName("redirect:/home");
//        return mv;
//    } //delete
//
//
//    @GetMapping("/findid")
//    public String findId(Model model){
//        return "html/user/userFindId";
//    }
//
//    @GetMapping("/findpw")
//    public String findpw(Model model){
//        return "html/user/userFindPassword";
//    }


}