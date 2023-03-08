package com.prj.web.admin.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminMainController {
    // 어드민 메인 페이지
    @GetMapping("/main")
    public String adMain(Model model) {
        System.out.println("관리자 메인 페이지로 이동");
        return "html/admin/admin";
    }
}
