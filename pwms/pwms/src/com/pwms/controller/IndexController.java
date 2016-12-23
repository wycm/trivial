package com.pwms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pwms.pojo.Course;
import com.pwms.pojo.TheoryCourse;
import com.pwms.pojo.NoticeTheroyContruction;
import com.pwms.pojo.Process;
import com.pwms.service.ICourseService;
import com.pwms.service.ITheoryCourseService;
import com.pwms.service.INoticeService;
import com.pwms.service.IProcessService;
import com.pwms.service.IUserService;
import com.pwms.tools.ArticleTools;
@Controller
@RequestMapping("")
public class IndexController extends BaseController{
	@Resource
	private INoticeService noticeService;
	@Resource
	private ICourseService courseService;
	@Resource
	private ITheoryCourseService theoryCourseService;
	@Resource
	private IUserService userService;
	@Resource
	private IProcessService processService;
	//首页
    @RequestMapping("/index")
    public String index(Model model,HttpSession session){
    	Integer [] atid = new Integer[]{2,3,4,5};
    	//最新的通知公告丶党建专项丶理论学习丶重要文件
    	List<NoticeTheroyContruction> allTop = noticeService.selectTopArticleByAtid(atid);
    	//最新的党校公告和新闻
    	List<NoticeTheroyContruction> xWAndDXGG = noticeService.selectTopXWAndDXGG();
    	session.setAttribute("user", userService.getUserById(4));
    	classify(allTop,model);
    	classifyXWAndDXGG(xWAndDXGG,model);
    	model.addAttribute("tcList", theoryCourseService.selectTopCourse());//获取最新理论课程
    	return "website/index";
    }
    @RequestMapping("/register")
    public String register(Model model){
    	return "website/register";
    }
    @RequestMapping("/login")
    public String login(Model model){
    	return "website/login";
    }
    @RequestMapping("/jpprocess")
    public String jpprocess(Model model){
    	return "website/jpprocess";
    }
    @RequestMapping("/admin/welcome")
    public String welcome(){
    	return "admin/welcome";
    }
    /**
     * 将按照一级栏目进行分类
     * @param list
     * @param model
     */
    public void classify(List<NoticeTheroyContruction> list,Model model){
    	String pAtValue;
    	List<NoticeTheroyContruction> tzgg = new ArrayList<NoticeTheroyContruction>();//通知公告
    	List<NoticeTheroyContruction> djzx = new ArrayList<NoticeTheroyContruction>();//党建专项
    	List<NoticeTheroyContruction> llxx = new ArrayList<NoticeTheroyContruction>();//理论学习
    	List<NoticeTheroyContruction> zywj = new ArrayList<NoticeTheroyContruction>();//重要文件
    	for(int i = 0;i < list.size();i++){
    		pAtValue = list.get(i).getArticletype().getpArticletype().getValue();
    		switch(pAtValue){
    			case "通知公告":tzgg.add(list.get(i));break;
    			case "党建专项":djzx.add(list.get(i));break;
    			case "理论学习":llxx.add(list.get(i));break;
    			case "重要文件":zywj.add(list.get(i));break;
    			default:break;
    		}
    	}
    	model.addAttribute("tzggList", tzgg);
    	model.addAttribute("djzxList", djzx);
    	model.addAttribute("llxxList", llxx);
    	model.addAttribute("zywjList", zywj);
    }
    /**
     * 将把新闻和党校公告进行分类
     * @param list
     * @param model
     */
    public void classifyXWAndDXGG(List<NoticeTheroyContruction> list,Model model){
    	String atValue;
    	List<NoticeTheroyContruction> xw = new ArrayList<NoticeTheroyContruction>();//通知公告
    	List<NoticeTheroyContruction> dxgg = new ArrayList<NoticeTheroyContruction>();//党建专项
    	for(int i = 0;i < list.size();i++){
    		atValue = list.get(i).getArticletype().getValue();
    		switch(atValue){
    			case "新闻":xw.add(list.get(i));break;
    			case "党校公告":dxgg.add(list.get(i));break;
    			default:break;
    		}
    	}
    	model.addAttribute("xwList", xw);
    	model.addAttribute("dxggList", dxgg);
    }
}
