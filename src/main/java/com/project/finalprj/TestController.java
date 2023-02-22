package com.project.finalprj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/item")
public class TestController {

    @Autowired
    private TestService testService;


    @RequestMapping(value="/test", method = RequestMethod.GET)
    public ModelAndView test(HttpServletRequest request) {
//        log.info("test 메소드 실행");

        ModelAndView mv = new ModelAndView("test");

        mv.addObject("varTest", "BBagayalow~");

        return mv;
    }

    @RequestMapping(value="/test2", method = RequestMethod.GET)
    public String test2(Model model) {
//        log.info("test2 메소드 실행");

        String test = (String)model.getAttribute("test");

//        log.info("test ::::::::::::::: {}", test);

        model.addAttribute("Bbaga", "babuting");

        return "test";
    }

    @RequestMapping(value="/newlist", method = RequestMethod.GET)
    public String retvNewItemList(Model model) {
//        log.info("retvNewItemList start");

        String ctgr1 = (String) model.getAttribute("ctgr1");
        String ctgr2 = (String) model.getAttribute("ctgr2");

        Map<String, Object> pMap = new HashMap<>();

        pMap.put("ctrg1", ctgr1);
        pMap.put("ctrg2", ctgr2);

        List<Map<String, Object>> list = testService.retvNewItemList(pMap);

        model.addAttribute("itemList", list);

        return "test";
    }
}
