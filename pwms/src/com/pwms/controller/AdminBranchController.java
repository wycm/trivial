package com.pwms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pwms.pojo.Branch;
import com.pwms.pojo.BranchMember;
import com.pwms.pojo.User;
import com.pwms.service.IBranchService;
import com.pwms.service.IUserService;

//后台管理，支部管理
@Controller
@RequestMapping("/admin/branch")
public class AdminBranchController extends BaseController {
	@Resource
	private IBranchService branchService;
	@Resource
	private IUserService userService;
	//页面显示
	/**
	 * 查看所有支部
	 * @param model
	 * @return
	 */
	@RequestMapping("/branch-list")
	public ModelAndView showBranches(){
		ModelAndView mav = new ModelAndView("admin/branch/branch-list");
		System.out.println("显示所有支部");
		mav.addObject("branchList",branchService.findAll());
		return mav;
	}
	@RequestMapping("/branch-add")
	public String branchAddShow(){
		return "admin/branch/branch-add";
	}
	/**
	 * 显示支部内所有成员
	 * @param branchid
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/branch-member-list")
	public String showMember(@RequestParam("branch") int branchid, Model model){
		Branch branch = branchService.getBranch(branchid);
		model.addAttribute("bmList", branchService.getBranchMember(branch));
		return "admin/branch/branch-member-list";
	}
	/**
	 * 显示支部信息修改页面
	 * @param branchid
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/branch-info-modify")
	public String showBranchModify(@RequestParam("branch") int branchid, Model model){
		Branch branch = branchService.getBranch(branchid);
		String studentId = userService.getUserById(branch.getLeaderId()).getStuOrJobid();
		model.addAttribute("studentId", studentId);
		model.addAttribute("branch", branch);
		return "admin/branch/branch-info-modify";
	}
	/**
	 * 添加支部
	 * @param stuid
	 * @param branch
	 * @param model
	 * @return
	 */
	@RequestMapping("/addbranch")
	public String addBranch(@RequestParam("stuid") String stuid,Branch branch, Model model){
		int userId = userService.getUseridByStuid(stuid);
		branch.setLeaderId(userId);
		branchService.save(branch);
		model.addAttribute("msg", "添加支部成功");
		return "admin/notice-msg";
	}
	/**
	 * 添加支部成员
	 * @param memberid
	 * @param branchid
	 * @param model
	 * @return
	 */
	@RequestMapping("/addBranchMember")
	public String addMember(@RequestParam("stuid") String stuid, BranchMember bm, HttpSession session, Model model){
		Branch branch = (Branch) session.getAttribute("branch");
		User user = userService.getUserById(userService.getUseridByStuid(stuid));
		branchService.addMember(branch, user);
		model.addAttribute("msg", "支部成员添加成功！");
		return "admin/notice-msg";
	}
	/**
	 * 修改支部信息
	 * @param branch
	 * @param model
	 * @return
	 */
	@RequestMapping("/branchInfoModify")
	public String modify(@RequestParam("studentId") String studentId,Branch branch, Model model)
	{	
		int userId = userService.getUseridByStuid(studentId);
		branch.setLeaderId(userId);
		branchService.update(branch);
		model.addAttribute("msg", "支部信息修改成功");
		return "admin/notice-msg";
	}
	//支部管理员显示我的支部
	@RequestMapping("/mybranch")
	public String myBranch(HttpSession session, Model model){
		return null;
	}
	/**
	 * 添加支部成员
	 * @return
	 */
	@RequestMapping("/branch-member-add")
	public String addBranchMemeber(){
		return "admin/branch/branch-member-add";
	}
}
