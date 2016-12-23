package com.blog.controller.admin;

import com.blog.pojo.Comment;
import com.blog.service.CommentService;
import com.blog.util.JsonMsg;
import com.blog.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by user on 2016/7/4.
 */
@Controller
@RequestMapping("/admin/comment")
public class AdminCommentController {
    @Autowired
    private CommentService commentService;
    @RequestMapping(value = "/comment-list", method = RequestMethod.GET)
    public String showCommentList(Model model){
        model.addAttribute("commentList", JsonUtils.ObjectToJson(commentService.findAdminVOList()));
        return "admin/comment-list";
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Object delete(Integer[] ids){
        for(int id:ids){
            commentService.delete(id);
        }
        return new JsonMsg("删除成功");
    }
    /**
     * 审核
     */
    @ResponseBody
    @RequestMapping(value = "/auditing", method = RequestMethod.GET)
    public Object auditing(Integer[] ids, Integer throughFlag){
        for(Integer id:ids){
            Comment c = commentService.findById(id);
            c.setThroughFlag(throughFlag);
            c.setAuditingFlag(1);
            commentService.update(c);
        }
        return new JsonMsg("审核成功!");
    }
}
