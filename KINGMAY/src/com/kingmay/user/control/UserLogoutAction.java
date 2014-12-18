package com.kingmay.user.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.beans.User;
import com.kingmay.utils.UserStore;
import com.opensymphony.xwork2.ActionSupport;

public class UserLogoutAction extends ActionSupport{
	public UserLogoutAction(){}
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		if(UserStore.exist(u.getUlname())){
			UserStore.delUser(u.getUlname());
		}
		session.removeAttribute("user");
		request.removeAttribute("que");
		return SUCCESS;
	}
}
