package com.kingmay.usercontrol.control;

import com.kingmay.admin.dao.UserDao;
import com.kingmay.beans.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserValidateAction extends ActionSupport{
	private User u;
	private UserDao userDao;
	private String regpwd;
	
	public UserValidateAction(){}

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

	public String getRegpwd() {
		return regpwd;
	}

	public void setRegpwd(String regpwd) {
		this.regpwd = regpwd;
	}

	@Override
	public String execute() throws Exception {
//		System.out.println(u.getUid());
		User uu = userDao.QueryUserByUid(u.getUid());
		if(uu == null){
			return INPUT;
		}else{
			userDao.vaildateUser(u);
			return SUCCESS;
		}
	}
	
	
	
}
