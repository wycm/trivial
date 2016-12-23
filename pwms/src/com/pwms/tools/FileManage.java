package com.pwms.tools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件的管理
 * @author Administrator
 *
 */
public class FileManage{
	public static void main(String args []) throws Exception{
		FileManage.copyDirectiory("D:/Program Files (x86)/Apache Software Foundation/Tomcat 7.0/webapps/pwms/upload", 
				"D:\\myworkspaces\\git repertory\\pwms\\pwms\\WebRoot\\upload\\");
	}
	/**
	 * 文件的下载
	 * @param request
	 * @param response
	 * @param storeName 文件名
	 * @throws Exception
	 */
	  public static void download(HttpServletRequest request,  
	      HttpServletResponse response, String storeName) throws Exception {  
	    request.setCharacterEncoding("UTF-8");  
	    BufferedInputStream bis = null;  
	    BufferedOutputStream bos = null;  
	  
	    //获取项目根目录
	    String ctxPath = request.getSession().getServletContext()  
	        .getRealPath("");  
	    
	    //获取下载文件露肩
	    String downLoadPath = ctxPath+"/WEB-INF/upload/"+ storeName;  
	  
	    //获取文件的长度
	    long fileLength = new File(downLoadPath).length();  

	    //设置文件输出类型
	    response.setContentType("application/octet-stream");  
	    response.setHeader("Content-disposition", "attachment; filename="  
	        + new String(storeName.getBytes("utf-8"), "ISO8859-1")); 
	    //设置输出长度
	    response.setHeader("Content-Length", String.valueOf(fileLength));  
	    //获取输入流
	    bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
	    //输出流
	    bos = new BufferedOutputStream(response.getOutputStream());  
	    byte[] buff = new byte[2048];  
	    int bytesRead;  
	    while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
	      bos.write(buff, 0, bytesRead);  
	    }  
	    //关闭流
	    bis.close();  
	    bos.close(); 
	    System.out.println("下载文件\n" + downLoadPath+ "\n成功！");
	  }  
	  /**
		 * 
		 * @param sourceFilePath 要复制文件的路径
		 * @param targetFilePath 目标文件路径
		 * @throws IOException
		 */
	    public static void copyFile(String sourceFilePath, String targetFilePath) throws IOException {
	        File sourceFile = new File(sourceFilePath);
	        File targetFile = new File(targetFilePath);
	    	BufferedInputStream inBuff = null;
	        BufferedOutputStream outBuff = null;
	        try {
	            // 新建文件输入流并对它进行缓冲
	            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

	            // 新建文件输出流并对它进行缓冲
	            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

	            // 缓冲数组
	            byte[] b = new byte[1024 * 5];
	            int len;
	            while ((len = inBuff.read(b)) != -1) {
	                outBuff.write(b, 0, len);
	            }
	            // 刷新此缓冲的输出流
	            outBuff.flush();
	        } finally {
	            // 关闭流
	            if (inBuff != null)
	                inBuff.close();
	            if (outBuff != null)
	                outBuff.close();
	        }
	    }
	    public static void copyFile(File sourcefile,File targetFile) throws IOException{
	        //新建文件输入流并对它进行缓冲
	        FileInputStream input=new FileInputStream(sourcefile);
	        BufferedInputStream inbuff=new BufferedInputStream(input);
	        //新建文件输出流并对它进行缓冲
	        FileOutputStream out=new FileOutputStream(targetFile);
	        BufferedOutputStream outbuff=new BufferedOutputStream(out);
	        //缓冲数组
	        byte[] b=new byte[1024*5];
	        int len=0;
	        while((len=inbuff.read(b))!=-1){
	            outbuff.write(b, 0, len);
	        }
	        //刷新此缓冲的输出流
	        outbuff.flush();
	        //关闭流
	        inbuff.close();
	        outbuff.close();
	        out.close();
	        input.close();
	    }
	    /**
	     * 复制目录
	     * @param sourceDir
	     * @param targetDir
	     * @throws IOException
	     */
	    public static void copyDirectiory(String sourceDir,String targetDir) throws IOException{
	        //新建目标目录
	        (new File(targetDir)).mkdirs();
	        //获取源文件夹当下的文件或目录
	        File[] file=(new File(sourceDir)).listFiles();
	        System.out.println(file.length);
	        for (int i = 0; i < file.length; i++) {
	            if(file[i].isFile()){
	                //源文件
	                File sourceFile=file[i];
	                //目标文件
	                File targetFile=new File(new File(targetDir).getAbsolutePath()+File.separator+file[i].getName());
	                copyFile(sourceFile, targetFile);
	            }
	            if(file[i].isDirectory()){
	                //准备复制的源文件夹
	                String dir1=sourceDir+"/"+file[i].getName();
	                //准备复制的目标文件夹
	                String dir2=targetDir+"/"+file[i].getName();
	                copyDirectiory(dir1, dir2);
	            }
	        }
	    }
}