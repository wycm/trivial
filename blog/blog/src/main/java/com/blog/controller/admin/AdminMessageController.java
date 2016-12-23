package com.blog.controller.admin;

import com.blog.pojo.Message;
import com.blog.service.MessageService;
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
@RequestMapping("/admin/message")
public class AdminMessageController {
    @Autowired
    private MessageService messageService;
    @RequestMapping(value = "/message-list", method = RequestMethod.GET)
    public String showUserList(Model model){
        model.addAttribute("messageList", JsonUtils.ObjectToJson(messageService.findAdminVOList()));
        return "admin/message-list";
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
            messageService.delete(id);
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
            Message c = messageService.findById(id);
            c.setThroughFlag(throughFlag);
            c.setAuditingFlag(1);
            messageService.update(c);
        }
        return new JsonMsg("审核成功!");
    }
}
