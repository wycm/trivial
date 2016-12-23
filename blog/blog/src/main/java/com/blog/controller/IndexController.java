package com.blog.controller;

import com.blog.pojo.Article;
import com.blog.service.ArticleService;
import com.blog.service.voservice.HeaderSiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wy on 2016/6/23 0023.
 */
@Controller
@RequestMapping("")
public class IndexController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private HeaderSiderService headerSiderService;
    //网站首页
    @RequestMapping("/index")
    public String index(Model model, HttpServletRequest request){
        headerSiderService.SessionManage(request.getServletContext());
        List<Article> articleList = articleService.getAllArticle();
        model.addAttribute("articleList", articleList);
        return "index";
    }
    //网站header部分
    @RequestMapping("/header")
    public String header(Model model, HttpServletRequest request){
        headerSiderService.SessionManage(request.getServletContext());
        List<Article> articleList = articleService.getAllArticle();
        model.addAttribute("articleList", articleList);
        return "header";
    }
    @RequestMapping("/sider")
    public String sider(Model model){
        return "sider";
    }
}
