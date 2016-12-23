package com.gdms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdms.pojo.Issue;
import com.gdms.pojo.User;
import com.gdms.service.IssueService;
import com.gdms.service.StuTutorService;
import com.gdms.service.TutorStuService;
import com.gdms.service.UserService;
import com.gdms.vo.UserVO;
/**
 * 选择控制器
 * @author user
 *
 */
@Controller
@RequestMapping("/choise")
public class ChoiseController extends BaseController {
	@Resource
	private UserService userService;
	@Resource
	private StuTutorService stuTutorService;
	@Resource
	private TutorStuService tutorStuService;
	@Resource
	private IssueService issueService;

	public IssueService getIssueService() {
		return issueService;
	}

	public void setIssueService(IssueService issueService) {
		this.issueService = issueService;
	}

	public StuTutorService getStuTutorService() {
		return stuTutorService;
	}

	public void setStuTutorService(StuTutorService stuTutorService) {
		this.stuTutorService = stuTutorService;
	}

	public TutorStuService getTutorStuService() {
		return tutorStuService;
	}

	public void setTutorStuService(TutorStuService tutorStuService) {
		this.tutorStuService = tutorStuService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	/**
	 * 获得本专业所有的老师列表
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/teacher_list")
	public String getTeacherList(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		List<User> teacherList = userService.getTeacherByMajor(user.getMajor());
		for (int i = 0; i < teacherList.size(); i++) {
			User teacher = teacherList.get(i);
			teacher.setTotal(stuTutorService.getAmountByTeacherId(teacher
					.getId()));
		}
		User teacher = stuTutorService.getMyTeacher(user);
		model.addAttribute("teacherList", teacherList);
		model.addAttribute("myteacher", teacher);
		return "gd/choose-teacher-list";
	}

	@RequestMapping("/choise-teacher")
	public String stuTutor(int teacher_id, HttpSession session,
			HttpServletResponse response) {
		User user = (User) session.getAttribute("user");
		// Map<String, Object> map =new HashMap<String, Object>();
		// ModelAndView modelAndView = new ModelAndView(new
		// MappingJacksonJsonView(),map);
		if (user == null) {
			// map.put("msg", "请登录");
			// return modelAndView;
			return publishmsg("请登录", response);
		}
		if (stuTutorService.create(teacher_id, user)) {
			// map.put("msg", "成功");
			return publishmsg("成功", response);
		} else {
			// map.put("msg","失败");
			return publishmsg("失败:导师未设置可选数量，或超过数量", response);
		}

	}
	/**
	 * 获取选择自己的学生列表
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/student_list")
	public String getStudentList(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		if (!user.haveTeacherPermission()) {
			model.addAttribute("msg", "你没有老师权限");
			return "gd/as-student-list";
		} else {
			//已选择该老师的为导师的学生列表
			List<User> sCTList = userService.getStudentChoiseMeByTeacher(user);
			//该老师已经同意选择的学生列表
			List<User> tCSList = userService.getStudentByTeacher(user);
			List<UserVO> userVOList = new ArrayList<UserVO>();
			for(User u:sCTList){
				boolean equalFlag = false;
				for(User u1:tCSList){
					if(equal(u, u1)){
						equalFlag = true;
					}
				}
				UserVO uv = new UserVO();
				BeanUtils.copyProperties(u, uv);
				if(equalFlag){
					//该老师已选择该学生
					uv.settCSFlag(1);
				}
				else{
					uv.settCSFlag(0);
				}
				userVOList.add(uv);
			}
			model.addAttribute("studentList", userVOList);
			return "gd/as-student-list";
		}
	}
	/**
	 * 判断两个User是否为同一个
	 * @param user1
	 * @param user2
	 * @return
	 */
	public boolean equal(User user1, User user2){
		if(user1.getId() == user2.getId()){
			return true;
		}
		return false;
	}
	/**
	 * 选择学生
	 * @param student_id
	 * @param session
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping("/choise-student")
	public String tutorStu(int student_id[], HttpSession session, Model model,
			HttpServletResponse response) {
		User user = (User) session.getAttribute("user");
		if (!user.haveTeacherPermission()) {
			return publishmsg("你没有这个权限", response);
		} else {
			if (tutorStuService.createByArr(student_id, user.getId())) {
				return publishmsg("成功", response);
			} else {
				return publishmsg("失败，可能原因：到达上限，或者没有设置上限", response);
			}
		}
	}

	@RequestMapping("/studentsmajor")
	public String studentsMajor(int teacherId, HttpSession session, Model model) {
		/**
		 * 分配学生的视图，包含学生列表和老师列表
		 */
		User user = (User) session.getAttribute("user");
		List<User> studentList = tutorStuService.getLastStudentByMajor(user
				.getMajor());
		// List<User> teacherList =
		// userService.getTeacherByMajor(user.getMajor());
		model.addAttribute("studentList", studentList);
		model.addAttribute("teacherId", teacherId);
		// model.addAttribute("teacherList", teacherList);
		return "gd/student-list";
	}

	@RequestMapping("/teachermajor")
	public String showteacherList(HttpSession session, Model model) {
		/**
		 * 分配学生的视图，包含学生列表和老师列表
		 */
		User user = (User) session.getAttribute("user");
		// List<User> studentList =
		// tutorStuService.getLastStudentByMajor(user.getMajor());
		List<User> teacherList = userService.getTeacherByMajor(user.getMajor());
		// model.addAttribute("studentList", studentList);
		model.addAttribute("teacherList", teacherList);
		return "gd/as-teacher-list";
	}

	@RequestMapping("/distribute")
	public String distributeStudent(int[] studentId, int teacherId,
			HttpServletResponse response) {
		/**
		 * 分配学生
		 */
		tutorStuService.distributeStudent(studentId, teacherId);
		return publishmsg("成功", response);
	}

	@RequestMapping("/xlsexport")
	public String xlsExport(String test, HttpSession session,
			HttpServletRequest request, Model model) {
		String path = request.getSession().getServletContext().getRealPath("")
				+ "/upload/";
		System.out.println("path:" + path);
		User user = (User) session.getAttribute("user");
		if (test != null && test.equals("test")) {
			tutorStuService.exportAllXls(path + "collegeresult.xls");
			return "redirect:" + "/upload/collegeresult.xls";
		}
		if (user.haveDirectorPermission()) {
			tutorStuService
					.exportMajorXls(user.getMajor(), path + "result.xls");
			return "redirect:" + "/upload/result.xls";
		} else if (user.haveLeaderPermission()) {
			tutorStuService.exportAllXls(path + "collegeresult.xls");
			return "redirect:" + "/upload/collegeresult.xls";
		} else {
			model.addAttribute("msg", "没有权限");
			return "notice-msg";
		}
	}
	@RequestMapping("/getMyProgress")
	public String getMyProgress(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		if (user.isStudent()) {
			User choiseTeacher = stuTutorService.getMyTeacher(user);
			User teacherChoise = tutorStuService.getTeacherByStudent(user.getId());
			Issue issue = issueService.getStudentIssue(user);
			boolean isChoiseTeacher = (choiseTeacher != null);
			boolean isTeacherChoise = (teacherChoise != null);
			boolean isChoiseIssue = (issue!=null);
			System.out.println("isChoiseTeacher:"+isChoiseTeacher);
			model.addAttribute("isChoiseTeacher", isChoiseTeacher);
			model.addAttribute("isTeacherChoise", isTeacherChoise);
			model.addAttribute("isChoiseIssue", isChoiseIssue);
			return "progress/progress";
		}else{
			model.addAttribute("msg", "你不能查看");
			return "notice-msg";
		}
	}
}
