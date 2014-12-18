package com.kingmay.user.control;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.admin.dao.UserDao;
import com.kingmay.beans.Child;
import com.opensymphony.xwork2.ActionSupport;

public class GoChangeDataAction extends ActionSupport{
	private String cid;
	private UserDao userDao;
	
	public GoChangeDataAction(){}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public String execute() throws Exception {
		cid = java.net.URLDecoder.decode(cid,"UTF-8");
		Child c = userDao.QueryChildById(cid);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		if(c == null){
			return INPUT;
		}
		session.setAttribute("child", c);
		
		if(c.getCyear() >= 4){
			return "4";
		}else{
			return "2";

		}
	}
	
	
}
