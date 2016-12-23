package com.blog.controller;

import com.blog.pojo.Article;
import com.blog.pojo.User;
import com.blog.service.UserService;
import com.blog.service.voservice.UserSiderService;
import com.blog.vo.UserSider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * Created by wy on 2016/6/25 0025.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserSiderService usService;
    /**
     * 显示登录页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(){
        return "login";
    }
    /**
     * 处理用户登录请求
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model
            , @ModelAttribute("user") User user
            , HttpSession session){
        if(userService.login(model, user, session)){
            return "redirect:/index";
        }
        else{
            return "login";
        }
    }
    /**
     *显示注册页面
     */
    @RequestMapping("/register")
    public String showRegisterPage(){
        return "register";
    }

    /**
     * 用户首页
     * @return
     */
    @RequestMapping("/{userId}")
    public String showUserIndex(Model model, @PathVariable Integer userId){
        UserSider us = usService.getUserSider(userId);
        model.addAttribute("userSider", us);
        Set<Article> articleList = userService.findById(userId).getArticles();
        model.addAttribute("articleList", articleList);
        return "user/userindex";
    }
}
