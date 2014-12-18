package com.kingmay.user.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.admin.dao.UserDao;
import com.kingmay.beans.User;
import com.opensymphony.xwork2.ActionSupport;

public class GoChangeInfoAction extends ActionSupport{
	private User u;
	private UserDao userDao;
	
	public GoChangeInfoAction(){}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		u = (User) session.getAttribute("user");
		u = userDao.QueryUserByUid(u.getUid());
		u.setUiden(u.getUiden().substring(0,14)+"****");
		return SUCCESS;
	}
	
	
}
