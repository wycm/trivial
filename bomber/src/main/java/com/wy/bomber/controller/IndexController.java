package com.wy.bomber.controller;

import com.wy.bomber.pojo.Source;
import com.wy.bomber.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wy on 11/1/2016.
 */
@Controller
public class IndexController {
    @Autowired
    private SourceService sourceService;
    @RequestMapping("/index")
    public String index(Model model){
        Source source = sourceService.findById(1);
        model.addAttribute("source", source);
        return "index";
    }
}
