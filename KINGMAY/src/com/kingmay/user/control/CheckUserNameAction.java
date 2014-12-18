package com.kingmay.user.control;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.admin.dao.UserDao;
import com.opensymphony.xwork2.ActionSupport;

public class CheckUserNameAction extends ActionSupport {
	public UserDao userDao;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpSession session = request.getSession();

	public CheckUserNameAction() {
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public String execute() throws Exception {

		String ulname = request.getParameter("userName");

		String responseString = null;

		if (userDao.noUlname(ulname)) {
			responseString = "false";
		} else {
			responseString = "true";
		}
		try {

			response.getWriter().write(responseString);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
