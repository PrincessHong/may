package com.kingmay.user.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.admin.dao.UserDao;
import com.kingmay.beans.User;
import com.opensymphony.xwork2.ActionSupport;

public class GOForgetPwdwordAction extends ActionSupport{
	public String ulname;
	public UserDao userDao;
	public User u ;
	
	public GOForgetPwdwordAction(){}

	public String getUlname() {
		return ulname;
	}

	public void setUlname(String ulname) {
		this.ulname = ulname;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	@Override
	public String execute() throws Exception {
		u = userDao.ForgetPwd(ulname);
		if(u == null){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			request.setAttribute("forgetMsg","用户名错误，请重新输入");
			request.getRequestDispatcher("/goforget.jsp");
			return INPUT;
		}
		return SUCCESS;
	}

}
