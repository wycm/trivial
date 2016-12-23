package com.blog.controller.admin;

import com.blog.pojo.User;
import com.blog.service.UserService;
import com.blog.util.JsonUtils;
import com.blog.vo.UserVO;
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
 * Created by user on 2016/7/3.
 */
@Controller
@RequestMapping("/admin/user")
public class AdminUserController {
    @Autowired
    private UserService userService;
    @ResponseBody
    @RequestMapping(value = "getUserList.json", method = RequestMethod.GET)
    public List<UserVO> getUserListJson(Model m){
        List<User> userList = userService.findAll();
        List<UserVO> userVOList = new ArrayList<UserVO>();
        for(User u:userList){
            UserVO uv = new UserVO();
            BeanUtils.copyProperties(u, uv,"password","url","headpicname","articles","bloginfo");
            userVOList.add(uv);
        }
        return userVOList;
    }
    @RequestMapping(value = "/user-list", method = RequestMethod.GET)
    public String showUserList(Model model){
        List<User> userList = userService.findAll();
        List<UserVO> userVOList = new ArrayList<UserVO>();
        for(User u:userList){
            UserVO uv = new UserVO();
            BeanUtils.copyProperties(u, uv,"password","url","headpicname","articles","bloginfo");
            userVOList.add(uv);
        }
        model.addAttribute("userList", JsonUtils.ObjectToJson(userVOList));
        return "admin/user-list";
    }
}
