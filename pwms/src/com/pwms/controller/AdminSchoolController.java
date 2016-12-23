package com.pwms.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pwms.pojo.CoureseGroup;
import com.pwms.pojo.Course;
import com.pwms.pojo.Exam;
import com.pwms.pojo.ExamQuestion;
import com.pwms.pojo.ExamRecord;
import com.pwms.pojo.TheoryCourse;
import com.pwms.service.ICourseGroupService;
import com.pwms.service.ICourseService;
import com.pwms.service.IExamQuestionService;
import com.pwms.service.IExamService;
import com.pwms.service.ITheoryCourseService;
import com.pwms.tools.ParseQuestion;

//党校管理
@Controller
@RequestMapping("/admin/school")
public class AdminSchoolController extends BaseController {
	
	@Resource
	private ICourseService courseService;
	@Resource
	private IExamService examService;
	@Resource
	private ICourseGroupService groupService;
	@Resource
	private ITheoryCourseService tcService;
	@Resource
	private IExamQuestionService eqService;
	/**
	 * 显示添加视频课程页面
	 * @return
	 */
	@RequestMapping("/video-course-add")
	public String addVCShow(){
		return "admin/school/video-course-add";
	}
	/**
	 * 视频课程管理
	 * @param model
	 * @return
	 */
	@RequestMapping("/video-course-list")
	public String showCourse(Model model){
		List<Course> courseList = courseService.getCourseByDate();
		model.addAttribute("courseList", courseList);
		return "admin/school/video-course-list";
	}
	/**
	 * 添加视频课程
	 * @param course
	 * @param request
	 * @return
	 */
	@RequestMapping("/addCourse")
	public String addCourse(@RequestParam(value = "file", required = false) MultipartFile file,Course course,HttpServletRequest request,Model model){
		String path = request.getSession().getServletContext().getRealPath("") + "/upload/video/";//
		String fileName = file.getOriginalFilename();
		fileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("."));
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        System.out.println("文件上传至\n" + path + fileName + "\n成功！");
        course.setSummary("/upload/video/");
        course.setUserId(4);
        course.setDateline(new Date());
        courseService.save(course);
		model.addAttribute("msg", "课程添加成功！");
		return "admin/notice-msg";
	}
	/**
	 * 显示视频课程修改页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/video-course-modify/{id}")
	public String showCourseModify(@PathVariable int id,Model model){
		model.addAttribute("course", courseService.getCourse(id));
		return "admin/school/video-course-modify";
	}
	/**
	 * 修改视频课程
	 * @param model
	 * @param course
	 * @return
	 */
	@RequestMapping("/modifyVideoCourse")
	public String modifyCourse(Model model,Course course){
		course.setDateline(new Date());
		course.setUserId(4);
		courseService.updateById(course);
		model.addAttribute("msg","视频课程修改成功！");
		return "admin/notice-msg";
	}
	/**
	 * 显示理论课程列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/theory-course-list")
	public String getTCourse(Model model){
		List<TheoryCourse> tCourseList = tcService.getTheoryCourseList();
		model.addAttribute("tCourseList", tCourseList);
		return "admin/school/theory-course-list";
	}
	/**
	 * 显示添加理论课程页面
	 * @return
	 */
	@RequestMapping("/theory-course-add")
	public String addTCShow(){
		return "admin/school/theory-course-add";
	}
	/**
	 * 添加理论课程
	 * @param model
	 * @param tc
	 * @return
	 */
	@RequestMapping("/addTheoryCourse")
	public String addTC(Model model,TheoryCourse tc){
		tc.setDateline( new Date());
		tc.setGroupId(1);
		tc.setVisits(0);
		tc.setUserId(4);
		tcService.save(tc);
		model.addAttribute("msg","添加课程成功！");
		return "admin/notice-msg";
	}
	/**
	 * 显示理论课程修改页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/theory-course-modify/{id}")
	public String modifyTC(@PathVariable int id,Model model){
		TheoryCourse tc = tcService.getTheoryCourseById(id);
		model.addAttribute("tCourse", tc);
		return "admin/school/theory-course-modify";
	}
	/**
	 * 修改理论课程
	 * @param model
	 * @param tc
	 * @return
	 */
	@RequestMapping("/modifyTheoryCourse")
	public String modifyTC(Model model,TheoryCourse tc){
		tc.setDateline( new Date());
		tc.setUserId(4);
		tc.setGroupId(1);
		tcService.updateById(tc);
		model.addAttribute("msg","理论课程修改成功！");
		return "admin/notice-msg";
	}
	/**
	 * 根据id删除课程
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/theoryCourseDelete")
	public @ResponseBody String delTC(Model model,int id){
		tcService.deleteById(tcService.getTheoryCourseById(id));
		return "删除成功!";
	}
	/**
	 * 显示添加考试题目页面
	 * @return
	 */
	@RequestMapping("/exam-question-add")
	public String addEQShow(){
		return "admin/school/exam-question-add";
	}
	/**
	 * 显示考试题目列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/exam-question-list")
	public String getExamQuestion(Model model){
		model.addAttribute("eqList", eqService.getAllQuestionsList());
		return "admin/school/exam-question-list";
	}
	/**
	 * 添加考试题目
	 * 解析考试字符串
	 * @param model
	 * @param tc
	 * @return
	 */
	@RequestMapping("/addExamQuestion")
	public String addEQ(Model model,String parseQuestion,int examId){
		System.out.println("源字符串:" + parseQuestion);
		List<ExamQuestion> eqList = ParseQuestion.parse(parseQuestion, examId);
		for(ExamQuestion ex:eqList){
			System.out.println(ex.toString());
			eqService.saveQuestion(ex);
		}
		model.addAttribute("msg","添加考试题目成功！");
		return "admin/notice-msg";
	}
	/**
	 * 根据id删除考试题目
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/examQuestionDelete")
	public @ResponseBody String delEQ(Model model,int id){
		eqService.deleteQuestionById(id);
		return "删除成功!";
	}
	/**
	 * 显示考试题目修改页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/exam-question-modify/{id}")
	public String modifyEQ(@PathVariable int id,Model model){
		model.addAttribute("examQuestion", eqService.getExamQuestionById(id));
		return "admin/school/exam-question-modify";
	}
	/**
	 * 修改考试题目
	 * @param model
	 * @param tc
	 * @return
	 */
	@RequestMapping("/modifyExamQuestion")
	public String modifyEQ(Model model,ExamQuestion eq){
		if(eq.getOptionD().equals("")){
			eq.setOptionD(null);
		}
		eqService.updateByPrimaryKey(eq);
		model.addAttribute("msg","理论课程修改成功！");
		return "admin/notice-msg";
	}
	/**
	 * 显示添加考试页面
	 * @return
	 */
	@RequestMapping("/exam-add")
	public String addEShow(){
		return "admin/school/exam-add";
	}
	/**
	 * 添加考试
	 * @param model
	 * @param e
	 * @return
	 */
	@RequestMapping("addExam")
	public String addExam(Model model,Exam e){
		e.setAfterCourseId(1);
		examService.save(e);
		model.addAttribute("msg", "添加考试成功!");
		return "admin/notice-msg";
	}
	/**
	 * 查看所有考试
	 * @param model
	 * @return
	 */
	@RequestMapping("/exam-list")
	public String showExam(Model model){
		List<Exam> examList = this.examService.getExamDesc();
		model.addAttribute("examList", examList);
		return "admin/school/exam-list";
	}
	/**
	 * 显示考试修改页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/exam-modify/{id}")
	public String modifyE(@PathVariable int id,Model model){
		model.addAttribute("exam", examService.getExam(id));
		return "admin/school/exam-modify";
	}
	/**
	 * 修改考试
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/modifyExam")
	public String modifyE(Model model,Exam exam){
		examService.updateById(exam);
		model.addAttribute("msg", "考试修改成功!");
		return "admin/notice-msg";
	}
	/**
	 * 根据id删除考试
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/examDelete")
	public @ResponseBody String delE(Model model,int id){
		examService.deleteExamById(id);
		return "删除成功!";
	}
	/**
	 * 查看所有考试记录
	 * @param model
	 * @return
	 */
	@RequestMapping("/exam-record-list")
	public String showExamRecord(Model model){
		List<ExamRecord> examRecordList = this.examService.selectAll();
		System.out.println(examRecordList.get(0).getUser().toString());
		model.addAttribute("examRecordList", examRecordList);
		return "admin/school/exam-record-list";
	}
	/**
	 * 显示考试记录修改页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/exam-record-modify/{id}")
	public String modifyER(@PathVariable int id,Model model){
		model.addAttribute("examRecord", examService.getExamRecord(id));
		return "admin/school/exam-record-modify";
	}
	/**
	 * 修改考试记录
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/modifyExamRecord")
	public String modifyER(Model model,ExamRecord examRecord){
		examService.updateExamRecord(examRecord);
		model.addAttribute("msg", "考试修改成功!");
		return "admin/notice-msg";
	}
	/**
	 * 根据id删除考试成绩记录
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/examRecordDelete")
	public @ResponseBody String delER(Model model,int id){
		examService.deleteExamRecordById(id);
		return "删除成功!";
	}
	//查看课程组
	@RequestMapping("/showgroup")
	public String showGroup(Model model){
		List<CoureseGroup> groupList = this.groupService.getCourseGroupList();
		model.addAttribute("groupList", groupList);
		return null;
	}
	//查看课程组里所有的课程
	@RequestMapping("/group/{id}")
	public String group(@PathVariable int id, Model model){
		List<Course> courseList = this.courseService.getCourseByGroupId(id);
		model.addAttribute("courseList", courseList);
		return null;
	}
	//添加课程到课程组
	@RequestMapping("/group/addCourse")
	public String group(HttpServletRequest request, int groupid, int courseid, Model model){
		Course course = this.courseService.getCourse(courseid);
		CoureseGroup group = this.groupService.getCourseGroupById(groupid);
		if(group!=null&&course!=null){
			course.setGroupId(group.getId());
			this.courseService.save(course);
			return publishmsg(request, "增加成功", null );
		}else{
		    return publishmsg(request, "修改失败", null );
		}
	}
	//考试题目导入
	@RequestMapping("/exam/importxls/{id}")
	public String importXls(HttpServletRequest request, @PathVariable int id, File exam, Model model){
		this.eqService.xls2ExamQuestion(exam, id);
		return publishmsg(request, "导入成功", null );
	}
	//考试成绩导出
	@RequestMapping("/exam/exportxls")
	public String exportXls(File exam, Model model){
		return null;
	}
}
