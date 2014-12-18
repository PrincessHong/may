package com.kingmay.admin.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.admin.dao.UserDao;
import com.kingmay.beans.User;
import com.opensymphony.xwork2.ActionSupport;

public class AddUserAction extends ActionSupport{
	public AddUserAction(){}
	private User u;
	private int adduse;
	private UserDao userDao;
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
		u.setUcanuse(adduse+u.getUcanuse());
		if(userDao.AddUser(u)){
			return SUCCESS;
		}else{
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			request.setAttribute("addErrorMsg","添加主试失败，请确认登录名是否重复。");
			request.getRequestDispatcher("/manager/adduser.jsp");
			return INPUT;
		}
	}
	
	
}
