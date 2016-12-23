package com.blog.controller;

import com.blog.pojo.Comment;
import com.blog.pojo.User;
import com.blog.service.CommentService;
import com.blog.util.StaticConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by wy on 2016/6/28 0028.
 */
@Controller
@RequestMapping("")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "user/comment-manage")
    public String showCommentManage(Model model, HttpSession session){
        User u = (User) session.getAttribute("user");
        List<Comment> commentList = commentService.findByProperty("user.id", u.getId());
        model.addAttribute("commentList", commentList);
        model.addAttribute("currentPage", StaticConstants.personCenterEnum.plgl.toString());
        return "user/comment-manage";
    }
}
