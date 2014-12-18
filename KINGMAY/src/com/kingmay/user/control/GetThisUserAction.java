package com.kingmay.user.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.beans.User;
import com.opensymphony.xwork2.ActionSupport;

public class GetThisUserAction extends ActionSupport{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	private User u;
	
	public GetThisUserAction(){}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	
}
