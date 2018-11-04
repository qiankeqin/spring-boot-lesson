package com.segmentfault.springbootlesson5.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: spring-boot-lesson
 * @description:
 * @author: qiankeqin
 * @create: 2018-11-04 20:57
 **/
@Controller
public class JspDemoController {

    @RequestMapping("/jsp/index")
    public String index(Model model){
        model.addAttribute("message","world");
        return "index";
    }
}
