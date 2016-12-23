package com.blog.controller;

/**
 * Created by wy on 2016/6/28 0028.
 */

import com.blog.pojo.Message;
import com.blog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @RequestMapping(value = "/msgboard",method = RequestMethod.GET)
    public String showMsgBoard(Model model){
        List<Message> messageList = messageService.getAllParMessages();
        model.addAttribute("parMsgs", messageList);
        return "msgboard";
    }
}
