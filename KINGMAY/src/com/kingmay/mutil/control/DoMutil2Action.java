package com.kingmay.mutil.control;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.beans.Age2;
import com.kingmay.beans.Age4;
import com.kingmay.beans.Child;
import com.opensymphony.xwork2.ActionSupport;

public class DoMutil2Action extends ActionSupport{
	private String FileName;
	private String filepath;
	private String file_p;
	
	public DoMutil2Action(){}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getFile_p() {
		return file_p;
	}

	public void setFile_p(String file_p) {
		this.file_p = file_p;
	}
	
	public InputStream getInputStream() throws Exception{
		System.out.println("file--->" +file_p);
		return ServletActionContext.getServletContext().getResourceAsStream(file_p);
	}
	
	public String getDownloadFileName(){
		String downFileName = file_p.substring(file_p.lastIndexOf("/")+1);
		System.out.println("文件："+downFileName);
		try{
			downFileName = new String(downFileName.getBytes(),"ISO8859-1");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return downFileName;
		
	}

	@Override
	public String execute() throws Exception {
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			FileName = (String) session.getAttribute("file");
			if(FileName == null){
				return INPUT;
			}
			
			
			filepath=ServletActionContext.getServletContext().getRealPath("upload")+"\\"+FileName;
			File file=new File(filepath);
			
			if(file == null){
				System.out.println("file is null");
				return INPUT;
			}
			
			List<Child> clist = new ArrayList<Child>();
			List<Age2> alist = new ArrayList<Age2>();
			
			DoExcel.read2007_2(filepath,clist,alist);
			
			FileName = (String) session.getAttribute("path");
			file_p = "/download/" + FileName + ".xlsx";
			System.out.println("--->"+file_p);
			
			filepath=ServletActionContext.getServletContext().getRealPath("download")+"\\"+FileName;
			return SUCCESS;
			
		}catch(Exception e){
			e.printStackTrace();
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			request.setAttribute("up2msg","生成数据失败，请准确填写数据");
			request.getRequestDispatcher("/manager/upload2.jsp");
			return INPUT;
		}
		
	}
	
	
	
}
