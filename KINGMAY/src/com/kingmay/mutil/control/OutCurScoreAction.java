package com.kingmay.mutil.control;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.beans.Age2;
import com.kingmay.beans.Age4;
import com.kingmay.beans.Child;
import com.kingmay.score.dao.AgeDao;
import com.opensymphony.xwork2.ActionSupport;

public class OutCurScoreAction extends ActionSupport{
	private List<Child> childs = new ArrayList<Child>();
	private AgeDao ageDao;
	private String FileName;
	private String filepath;
	private String file_p;

	public List<Child> getChilds() {
		return childs;
	}

	public void setChilds(List<Child> childs) {
		this.childs = childs;
	}

	public AgeDao getAgeDao() {
		return ageDao;
	}

	public void setAgeDao(AgeDao ageDao) {
		this.ageDao = ageDao;
	}

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
		System.out.println("ÎÄ¼þ£º"+downFileName);
		try{
			downFileName = new String(downFileName.getBytes(),"ISO8859-1");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return downFileName;
		
	}
	
	
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		if(childs.size() < 1){
			return INPUT;
		}
		
		List<Object> l = new ArrayList<Object>();
		l = ageDao.QueryAge(childs);
		if(l.get(0) instanceof Age2){
			System.out.println("2");
		}else if(l.get(0) instanceof Age4){
			System.out.println("4");
		}
		
		DoExcel.write_Yuan(childs,l);
		FileName = (String) session.getAttribute("path");
		file_p = "/download/" + FileName + ".xlsx";
		filepath=ServletActionContext.getServletContext().getRealPath("download")+"\\"+FileName;
		
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void validate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		childs = (List<Child>) session.getAttribute("childs");
		System.out.println("childs size--->"+childs.size());
		if(childs != null){
		}else{
			System.out.println("null");
		}
		
	}
	
	
	
	
}
