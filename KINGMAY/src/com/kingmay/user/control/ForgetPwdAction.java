package com.kingmay.user.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.beans.User;
import com.opensymphony.xwork2.ActionSupport;

public class ForgetPwdAction extends ActionSupport{
	private User u;
	private String ans;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	public ForgetPwdAction(){}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	@Override
	public String execute() throws Exception {
		request.setAttribute("pwd", u.getUlpwd());
		return SUCCESS;
	}

	@Override
	public void validate() {
		u = (User) session.getAttribute("user");
		if(!u.getUans().equals(ans)){
			addFieldError("ans","´ð°¸´íÎó");
		}
	}
	
	
}
