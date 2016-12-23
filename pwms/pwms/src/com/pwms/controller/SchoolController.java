package com.pwms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pwms.pojo.Articletype;
import com.pwms.pojo.Course;
import com.pwms.pojo.Exam;
import com.pwms.pojo.ExamRecord;
import com.pwms.pojo.NoticeTheroyContruction;
import com.pwms.pojo.TheoryCourse;
import com.pwms.pojo.User;
import com.pwms.service.ICourseService;
import com.pwms.service.IExamService;
import com.pwms.service.INoticeService;
import com.pwms.service.ITheoryCourseService;
import com.pwms.tools.ArticleTools;
/**
 * 网上党校
 * @author wy
 *
 */
@Controller
@RequestMapping("/school")
public class SchoolController extends BaseController {
	//查看所有的课程
	@Resource
	private ICourseService courseService;
	@Resource
	private IExamService examService;
	@Resource
	private INoticeService noticeService;
	@Resource
	private ITheoryCourseService tcService;
	@RequestMapping({"","/"})
	private String index(HttpServletRequest request, Model model){
		return getLLKCList(model);
	}
	@RequestMapping("/getcourses")
	public String getAllCourses(HttpServletRequest request, Model model) {
		List<Course> courseList = courseService.getCourseByDate();
		if(verifyClient(request)){
			outJson("{"+listToJson("courseList",courseList)+"}");
			return null;
		}
		model.addAttribute("courseList", courseList);
    	return null;
    }
	/**
	 * 获取该用户还未参加的考试
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/zxks/list")
	public String getExams(HttpServletRequest request, Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Exam> examList = examService.getExamListByUserId(user.getId());
		if(verifyClient(request)){
			outJson("{"+listToJson("examList",examList)+"}");
			return null;
		} 
		model.addAttribute("examList", examList);
    	return "website/school/online-exam-list";
    }
	//查看历史成绩
	@RequestMapping("/getgrade")
	public String getGrade(HttpServletRequest request, HttpSession session, Model model)
	{
		User user = (User) session.getAttribute("user");
		List<ExamRecord> examRecordList = this.examService.getRecord(user);
		if(verifyClient(request)){
			outJson("{"+listToJson("examRecordList",examRecordList)+"}");
			return null;
		} 
		model.addAttribute("examRecordList", examRecordList);
		return null;
	}
	@RequestMapping("/llkc/list")
	public String getLLKCList(Model model){
		List<TheoryCourse> tcList = tcService.getTheoryCourseList();
		model.addAttribute("tcList", tcList);
		return "website/school/theory-course-list";
	}
	@RequestMapping("/cjcx/list")
	public String getCJCX(Model model,HttpSession session){
		User user = (User)session.getAttribute("user");
		List<ExamRecord> erList = examService.getRecordByUserId(user.getId());
		model.addAttribute("erList", erList);
		return "website/school/score-list";
	}
	/**
	 * 访问网上党校下的列表
	 * @param type
	 * @param model
	 * @return
	 */
	@RequestMapping("/{type}/list")
	public String getList(@PathVariable String type, Model model){
		switch(type){
			case "spkc":getKCZX(model, "视频课程");return "website/school/video-course-list";
			case "xxjl":getArticleByType(model, "学习记录");return "website/school/study-record-list";
			default:getArticleByType(model, "视频课程");break;
		}
		return "website/school/list";
	}
	/**
	 * 该方法还要完善
	 * 根据类型获取文章列表
	 * @param model
	 * @param typeValue 文章类型的参数
	 */
	public void getArticleByType(Model model,String typeValue){
		List<NoticeTheroyContruction> noticeList = this.noticeService.getNoticeByType(1);
		model.addAttribute("articleList", noticeList);
		model.addAttribute("type", typeValue);
	}
	/**
	 * 获取课程列表
	 * @param type
	 * @param model
	 */
	public void getKCZX(Model model,String typeValue){
		model.addAttribute("type", typeValue);
		model.addAttribute("courseList",courseService.getCourseByDate());
	}
	/**
	 * 查看具体的视频课程
	 * @return
	 */
	@RequestMapping("/spkc/{id}/course")
	public String getVideoCourse(@PathVariable int id,Model model){
		Course course = courseService.getCourse(id);
		model.addAttribute("course", course);
		return "website/school/video-course-detail";
	}
	/**
	 * 查看具体理论课程
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/llkc/{id}/course")
	public String getTheoryCourse(@PathVariable int id,Model model){
		TheoryCourse tCourse = tcService.getTheoryCourseById(id);
		model.addAttribute("tCourse", tCourse);
		return "website/school/theory-course-detail";
	}
}
