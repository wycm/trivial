package com.blog.controller.admin;

import com.blog.pojo.Article;
import com.blog.pojo.ArticleType;
import com.blog.service.ArticleService;
import com.blog.service.ArticleTypeService;
import com.blog.util.JsonMsg;
import com.blog.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by user on 2016/7/4.
 */
@Controller
@RequestMapping("/admin/article-type")
public class AdminArticleTypeController {
    @Autowired
    private ArticleTypeService articleTypeService;
    @RequestMapping(value = "/article-type-list", method = RequestMethod.GET)
    public String showUserList(Model model){
        List<ArticleType> articleTypeList = articleTypeService.findAdminVOList();
        String json = JsonUtils.ObjectToJson(articleTypeList);
        model.addAttribute("articleTypeList", json);
        return "admin/article-type-list";
    }
    @RequestMapping(value = "/add-article-type", method = RequestMethod.GET)
    public String showAddArticleType(Model model){
        List<ArticleType> articleTypeList = articleTypeService.findParArticleTypeList();
        String json = JsonUtils.ObjectToJson(articleTypeList);
        model.addAttribute("articleTypeList", json);
        return "admin/add-article-type";
    }
    @RequestMapping(value = "/add-article-type", method = RequestMethod.POST)
    public String addArticleType(Model model, Integer pid, String atValue){

        articleTypeService.insertArticleType(pid, atValue);
        model.addAttribute("msg", "文章类型添加成功，关闭窗口后刷新");
        return "admin/msg";
    }
}
