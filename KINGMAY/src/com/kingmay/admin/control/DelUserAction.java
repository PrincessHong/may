package com.kingmay.admin.control;

import com.kingmay.admin.dao.UserDao;
import com.opensymphony.xwork2.ActionSupport;

public class DelUserAction extends ActionSupport{
	private String uid;
	private UserDao userDao;
	
	public DelUserAction(){}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public String execute() throws Exception {
		uid = java.net.URLDecoder.decode(uid,"UTF-8");
		System.out.println("uid-->" + uid);
		if(userDao.delUserByUid(uid)){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
}
