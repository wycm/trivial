package com.blog.controller.admin;

import com.blog.pojo.User;
import com.blog.service.UserService;
import com.blog.util.JsonUtils;
import com.blog.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wy on 2016/7/1 0001.
 */
@Controller
@RequestMapping("/admin")
public class AdminIndexController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/{type}",method = RequestMethod.GET)
    public String index(@PathVariable String type){
        return "admin/" + type;
    }
    @RequestMapping(value = "/angular-user-list", method = RequestMethod.GET)
    public String showUserList(Model model){

        return "admin/angular-user-list";
    }
}
