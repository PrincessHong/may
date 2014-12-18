package com.kingmay.admin.control;

import com.kingmay.admin.dao.UserDao;
import com.kingmay.beans.User;
import com.opensymphony.xwork2.ActionSupport;

public class AdminUserAction extends ActionSupport{
	private User u;
	private UserDao userDao;
	private int adduse;
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
	public int getAdduse() {
		return adduse;
	}
	public void setAdduse(int adduse) {
		this.adduse = adduse;
	}
	@Override
	public String execute() throws Exception {
		u.setUcanuse(u.getUcanuse()+adduse);
		if(userDao.updateUser(u)){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
}
