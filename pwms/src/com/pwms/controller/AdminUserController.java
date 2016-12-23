package com.pwms.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.ueditor.ActionEnter;
import com.pwms.pojo.JoinOutRecord;
import com.pwms.pojo.RewardPunishRecord;
import com.pwms.pojo.User;
import com.pwms.pojo.UserinfoModify;
import com.pwms.service.IJoinOutRecordService;
import com.pwms.service.IRewardPunishRecordService;
import com.pwms.service.IUserService;
import com.pwms.service.IUserinfoService;
import com.pwms.tools.FileManage;
/**
 * 后台用户信息管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin/user")
public class AdminUserController extends BaseController {
	@Resource
	private IRewardPunishRecordService rprService;
	@Resource
	private IJoinOutRecordService jorService;
	@Resource
	private IUserinfoService userinfoService;
	@Resource
	private IUserService userService;
	//负责页面显示
	@RequestMapping("/reward-punish-add")
	public String rewardPunishAdd(){
		return "admin/user/reward-punish-add";
	}
	@RequestMapping("/join-out-add")
	public String joinOutAdd(){
		return "admin/user/join-out-add";
	}
	/**
	 * 验证信息导入
	 * @return
	 */
	@RequestMapping("file-add")
	public String vlidateInfoImport(){
		return "admin/user/file-add";
	}
	/**
	 * 获取所有奖惩记录
	 * @param model
	 * @return
	 */
	@RequestMapping("/reward-punish-list")
	public ModelAndView getAllRPR(){
		ModelAndView mav = new ModelAndView("admin/user/reward-punish-list");
		List<RewardPunishRecord> allRPR = rprService.findAll();
		System.out.println(allRPR.size());
		mav.addObject("rpList", allRPR);
        return mav;
	}
	/**
	 * 获取所有转入转出记录
	 * @param model 
	 * @return
	 */
	@RequestMapping("/join-out-list")
	public ModelAndView getAllJOR(){
		ModelAndView mav = new ModelAndView("admin/user/join-out-list");
		mav.addObject("joList", jorService.findAll());
        return mav;
	}
	@RequestMapping("getJoinOut")
	public @ResponseBody List getJson(){
		return jorService.findAll();
	}
	/**
	 * 获取所有用户信息修改记录
	 * @return
	 */
	@RequestMapping("/userdetail-modify-list")
	public ModelAndView getAllUserinfoModify(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("admin/user/userdetail-modify-list");
		User u = new User();
		u.setId(4);
		HttpSession session = request.getSession();
		session.setAttribute("user", u);
		User user = (User) session.getAttribute("user");
		mav.addObject("udmList", userinfoService.getModifyByUserFlag(user, 0));
        return mav;
	}
	/**
	 * 通过用户id获取用户详细信息
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping("/user-show/{userId}")
	public String getUserinfo(@PathVariable int userId,Model model){
		model.addAttribute("userinfo", userinfoService.getUserinfoByUserid(userId));
		return "admin/user/user-show";
	}
	/**
	 * 通过信息修改id获取修改记录信息
	 * @param udmId 修改信息id
	 * @param model
	 * @return
	 */
	@RequestMapping("/userdetail-modify-show/{udmId}")
	public String getUserdetailModify(@PathVariable int udmId,Model model){
		model.addAttribute("userdetailModify", userinfoService.getUserinfoByUserid(udmId));
		return "admin/user/userdetail-modify-show";
	}
	//页面显示介绍
	/**
	 * 用户验证信息导入
	 * @param file
	 * @param request
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/importuserxls")
	 public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) throws IOException {  
        String path = request.getSession().getServletContext().getRealPath("") + "/upload/";//
        String fileName = file.getOriginalFilename();  
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
  
        //保存  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        System.out.println("文件上传至\n" + path + fileName + "\n成功！");
        model.addAttribute("msg", "文件导入成功！");
        return "admin/notice-msg";  
    }
	/**
	 * 审核用户信息修改，如果
	 * @param id 修改信息id
	 * @param flag 0表示通过，1表示不通过
	 * @return
	 */
	@RequestMapping(value="/userdetail-modify/{id}/{flag}")
	public @ResponseBody String deal(@PathVariable int id, @PathVariable int flag,HttpServletRequest request){
		UserinfoModify um = userinfoService.getUserinfoModifyByid(id);
		String msg = request.getParameter("msg");
		if(msg == null){
			msg = "";
		}
		System.out.println(id + "  " + flag + "  " + msg);
		userinfoService.dealModify(um, flag, msg);//有问题
		return "审核通过";
	}
	/**
	 * 导出详细用户信息
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping("/exportxls")
	public ModelAndView exportXls(HttpServletRequest request,  
		      HttpServletResponse response) throws Exception {  
		String storeName="11.xlsx";  
		FileManage.download(request, response, storeName);  
		return null;  
	} 
	/**
	 * 导出用户转入转出信息
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/exportout")
	public String exportOutXls(HttpServletRequest request,  
		      HttpServletResponse response) throws Exception{
		String storeName="11.xlsx";  
		FileManage.download(request, response, storeName);  
		return null;
	}
	/**
	 * 添加转入转出信息
	 * @param record
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/joinout",method=RequestMethod.POST)
	public String addJoinOut(JoinOutRecord record, Model model){
		//System.out.println("姓名：" + record.getName() + "日期：" + record.getOutDate());
		record.setUserId(1);
		jorService.save(record);
		model.addAttribute("msg", "转入转出记录添加成功！");
        return "admin/notice-msg";
	}
	/**
	 * 奖惩登记表导出
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/exportXlsReward")
	public String exportReward(HttpServletRequest request,  
		      HttpServletResponse response) throws Exception{
		String storeName="11.xlsx";  
		FileManage.download(request, response, storeName);  
		return null;
	}
	/**
	 * 添加奖惩记录
	 * @param record
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/rewOrPun",method=RequestMethod.POST)
	public String addReward(HttpServletRequest request, RewardPunishRecord record, Model model){
		System.out.println(record.getExplian());
		int userid = userService.getUseridByStuid(request.getParameter("stuid"));
		System.out.println("userid " + userid );
		record.setUserId(userid);//此处需要一个根据学号查询用户id的方法
		record.setRewPunDate(new Date());
		rprService.save(record);
		model.addAttribute("msg", "奖惩记录添加成功！");
        return "admin/notice-msg"; 
	}
	/**
	 * 删除奖惩记录
	 * @param record
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/rewOrPun/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable int id,HttpServletRequest request, Model model){
		System.out.println("删除奖惩记录成功！");
		//rprService.getRewardPunishRecord(id);
		model.addAttribute("msg", "删除奖惩记录添加成功！");
        return "admin/notice-msg"; 
	}
}
