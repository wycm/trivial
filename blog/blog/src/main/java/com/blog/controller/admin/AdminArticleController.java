package com.blog.controller.admin;

import com.blog.pojo.Article;
import com.blog.service.ArticleService;
import com.blog.util.JsonMsg;
import com.blog.util.JsonUtils;
import com.blog.vo.ArticleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2016/7/4.
 */
@Controller
@RequestMapping("/admin/article")
public class AdminArticleController {
    @Autowired
    private ArticleService articleService;
    @RequestMapping(value = "/article-list", method = RequestMethod.GET)
    public String showUserList(Model model){
        List<Article> articleList = articleService.findAdminVOList();
        String json = JsonUtils.ObjectToJson(articleList);
        model.addAttribute("articleList", json);
        return "admin/article-list";
    }
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(Integer[] ids){
        for(int id:ids){
            articleService.delete(id);
        }
        return JsonUtils.ObjectToJson(new JsonMsg("删除成功"));
    }
}
