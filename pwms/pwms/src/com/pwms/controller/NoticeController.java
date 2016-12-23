package com.pwms.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pwms.service.INoticeService;
import com.pwms.service.IUserService;
import com.pwms.tools.ArticleTools;
/**
 * 通知公告丶党建专项丶理论学习丶重要文件
 * @author Administrator
 *
 */
@Controller
//@RequestMapping({"/notice","/impdoc","/party","/theory"})
@RequestMapping({"/{fType:notice|impdoc|party|theory}"})
public class NoticeController extends BaseController {
	@Resource
	private INoticeService noticeService;
	@Resource
	private IUserService userService;
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public INoticeService getNoticeService() {
		return noticeService;
	}
	public void setNoticeService(INoticeService noticeService) {
		this.noticeService = noticeService;
	}
	@RequestMapping({"","/"})
	public String index(@PathVariable("fType") String fType,HttpServletRequest request, Model model){
		String s = null;
		switch(fType){
			case "impdoc":s = "dswx";break;
			case "party":s = "zyjs";break;
			case "theory":s = "lljd";break;
			default:s = "hdtz";break;
		}
		return getList(s,model);
	}
	/**
	 * 获取通知公告下的列表并返回
	 * @param type
	 * @param model
	 * @return
	 */
	@RequestMapping("/{type}/list")
	public String getList(@PathVariable String type, Model model){
		return ArticleTools.getArticleListByType(type, model, noticeService);
	}
	/**
	 * 获取具体文章并返回
	 * @param type
	 * @param model
	 * @return
	 */
	@RequestMapping("/{type}/{id}")
	public String getArticle(@PathVariable String type, @PathVariable Integer id,Model model){
		return ArticleTools.getArticleById(model, id, type, noticeService);
	}
	
}
