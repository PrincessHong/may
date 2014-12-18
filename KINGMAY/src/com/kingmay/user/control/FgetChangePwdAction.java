package com.kingmay.user.control;

import com.kingmay.admin.dao.UserDao;
import com.kingmay.beans.User;
import com.opensymphony.xwork2.ActionSupport;

public class FgetChangePwdAction extends ActionSupport{
	private String newPwd;
	private User u;
	private UserDao userDao; 
	
	public FgetChangePwdAction(){}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

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
		if(userDao.updateUlPwd(u.getUlname(), newPwd)){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	
}
