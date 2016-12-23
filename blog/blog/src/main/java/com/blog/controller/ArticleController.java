package com.blog.controller;

import com.blog.pojo.Article;
import com.blog.pojo.ArticleType;
import com.blog.pojo.Tag;
import com.blog.pojo.User;
import com.blog.service.ArticleService;
import com.blog.service.ArticleTypeService;
import com.blog.service.TagService;
import com.blog.service.UserService;
import com.blog.service.voservice.UserSiderService;
import com.blog.util.StaticConstants;
import com.blog.vo.UserSider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by wy on 2016/6/25 0025.
 */
@Controller
@RequestMapping("")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserSiderService usService;
    @Autowired
    private ArticleTypeService atService;
    @Autowired
    private TagService tagService;
    @Autowired
    private ArticleTypeService articleTypeService;
    /**
     * 按文章类型分类显示文章列表
     */
    @RequestMapping("/article/category/{linkname}")
    public String showArticlesByType(@PathVariable String linkname, Model model){
        ArticleType at = atService.findByProperty("linkname", linkname).get(0);
        model.addAttribute("title", at.getLinkname());
        model.addAttribute("articleList", at.getArticles());
        return "sort";
    }

    /**
     *按文章标签分类显示文章列表
     */
    @RequestMapping("/article/tag/{value}")
    public String showArticlesByTag(@PathVariable String value, Model model){
        Tag tag = tagService.findByProperty("value", value).get(0);
        model.addAttribute("title", tag.getValue());
        model.addAttribute("articleList", tag.getArticles());
        return "sort";
    }
    /**
     * 根据文章id显示文章详细内容
     */
    @RequestMapping("/user/{uid}/article/{aid}")
    public String showArticle(@PathVariable Integer uid
            , @PathVariable Integer aid
            , Model model){
        Article a = articleService.getArticle(aid);
        User user = userService.findById(uid);
        UserSider us = usService.getUserSider(user.getId());
        model.addAttribute("article", a);
        model.addAttribute("userSider", us);
        return "user/article";
    }

    /**
     * 显示发布文章页面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/user/add-article",method = RequestMethod.GET)
    public String showAddArticle(Model model, HttpSession session){
        User u = (User) session.getAttribute("user");
        List<ArticleType> articleTypes = articleTypeService.getAllChildrenArticleType();
        model.addAttribute("chiArticleTypes", articleTypes);
        List<Tag> tagList = tagService.getAllTags();
        model.addAttribute("tagList", tagList);
        model.addAttribute("currentPage", StaticConstants.personCenterEnum.fbwz.toString());
        return "user/add-article";
    }

    /**
     * 处理发布文章请求
     * @return
     */
    @RequestMapping(value = "/user/add-article",method = RequestMethod.POST)
    public String addArticle(){
        return "";
    }

    /**
     * 显示文章管理页面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/user/article-manage",method = RequestMethod.GET)
    public String showArticleManage(Model model,HttpSession session){
        User u = (User) session.getAttribute("user");
        List<Article> articleList = articleService.findByProperty("user.id", u.getId());
        model.addAttribute("articleList", articleList);
        model.addAttribute("currentPage", StaticConstants.personCenterEnum.wzgl.toString());
        return "user/article-manage";
    }
}
