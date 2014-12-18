package com.kingmay.user.control;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownAction extends ActionSupport{
	private String path;

	public DownAction(){}
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public InputStream getInputStream() throws Exception{
		return ServletActionContext.getServletContext().getResourceAsStream(path);
	}
	
	public String getDownloadFileName(){
		String downFileName = path.substring(path.lastIndexOf("/")+1);
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
		System.out.println("path---¡·"+path);
		return super.execute();
	}
	
}
