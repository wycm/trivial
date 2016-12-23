package com.pwms.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pwms.pojo.ExamQuestion;

public class ParseQuestion{
	public static void main(String args []){
//		String question = "1.\"三个代表\"重要思想是加强和改进党的建设、推进我国社会主义自我完善和发展的强大理论武器，是全党集体智慧的结晶，是(  )。B\n" +
//"A. 党的理论基础 B. 党必须长期坚持的指导思想 C. 党的行动指南" +
//"2. \"四个服从\"最重要的是（ ）。A" +
//"A. 全党服从中央 B. 下级服从上级 C. 少数服从多数" +
//"3. (    )是党内的最高处分 B" +
//"A. 撤销党内职务 B. 开除党籍 C. 严重警告" +
//"4. （   ），立党为公，执政为民，是我们党同一切剥削阶级政党的根本区别。B" +
//"A. 密切联系群众 B. 全心全意为人民服务 C. 实事求是" +
//"5. （  ），是邓小平和中国共产党对当代中国基本国情的科学判断。A" +
//"A. 我国处在社会主义初级阶段 B. 我国是发展中的社会主义国家 C. 社会主义在实践中" +
//"6. （  ）是争取入党的首要问题。C" +
//"A. 递交入党申请书 B. 汇报思想 C. 端正入党动机" +
//"7. （  ）正式把邓小平理论载入党章。 C" +
//"A. 党的十三大 B党的十四大 C. 党的十五大";
		String question = "1、 中国近代史以鸦片战争为开端，主要是因为(  )  C" +
				"A.中国第一次被西方国家战败     B.长期闭关锁国状况被打破" +
				"C.社会性质开始发生根本变化     D.民族矛盾取代了阶级矛盾" +
				"2、世界历史开始进入资本主义时代的标志是(  ) A" +
				"A.1640年英国资产阶级革命     B.1642年英国资产阶级革命 " +
				"C.1789年法国资产阶级革命     D.1790年法国资产阶级革命";
		parse(question,1);
	}
	/**
	 * 解析考试题目
	 * @param parseStr 要解析的字符串
	 * @return
	 */
	public static List<ExamQuestion> parse(String parseStr,int exameId){
		List<ExamQuestion> eqList = new ArrayList<ExamQuestion>();
		ExamQuestion eq = null;
	      String AQ = "";//问题已经答案
	      String answer = "";
	      int i = 0;
	      parseStr = parseStr.replaceAll(" |\\s+", "");//除去换行符和空格
	      Matcher m = null;
	      String [] s = parseStr.split("\\d{1,3}(\\.|·|、|丶)");
	      for(int j = 0;j < s.length;j++){
	    	  eq = new ExamQuestion();
	    	  eq.setExamId(1);
	    	  if(!s[j].equals("")){
	    		  AQ = s[j];
	    		  System.out.println(AQ);
	    	      m = Pattern.compile("[A-D]").matcher(AQ);
	    	      m.find();
	    	      answer = m.group();
	    	      parseStr = AQ.substring(0,AQ.indexOf(answer));
	    	      System.out.println("问题:" + parseStr);
	    	      m = Pattern.compile("[^A-D(\\.|．)][^ABCD\\.]*").matcher(AQ.substring(AQ.indexOf(answer) + 1));
	    	      i = 0;
	    	      while(m.find()){
	    	    	  i++;
	    	    	  if(i == 1){
	    	    		  System.out.println("A." + m.group(0));
	    	    		  eq.setOptionA(m.group(0));
	    	    	  }
	    	    	  else if(i == 2){
	    	    		  System.out.println("B." + m.group(0));
	    	    		  eq.setOptionB(m.group(0));
	    	    	  }
	    	    	  else if(i == 3){
	    	    		  System.out.println("C." + m.group(0));
	    	    		  eq.setOptionC(m.group(0));
	    	    	  }
	    	    	  else if(i == 4){
	    	    		  System.out.println("D." + m.group(0));
	    	    		  eq.setOptionD(m.group(0));
	    	    	  }
	    	      }
	    	      System.out.println("答案:"  + answer);
	    	      eq.setAnswer(answer);
	    	      eq.setQuestion(parseStr);
	    	      eqList.add(eq);
	    	  }
	    	  
	      }

		return eqList;
	}
}