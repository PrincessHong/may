package com.kingmay.admin.control;

import com.kingmay.admin.dao.UserDao;
import com.kingmay.beans.User;
import com.opensymphony.xwork2.ActionSupport;

public class GoAdminUserAction extends ActionSupport{
	private User u;
	private UserDao userDao;
	private String uid;
	
	public GoAdminUserAction(){}

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

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Override
	public String execute() throws Exception {
		uid = java.net.URLDecoder.decode(uid,"UTF-8");
		u = userDao.QueryUserByUid(uid);
		if(u !=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	
}
