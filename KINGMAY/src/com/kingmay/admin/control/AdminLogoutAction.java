package com.kingmay.admin.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.beans.Admin;
import com.kingmay.utils.UserStore;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLogoutAction extends ActionSupport{
	public AdminLogoutAction(){}

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Admin ad = (Admin) session.getAttribute("admin");
		if(UserStore.exist(ad.getAname())){
			UserStore.delUser(ad.getAname());
		}
		session.removeAttribute("admin");
		session.removeAttribute("currentPage");
		session.removeAttribute("totalPage");
		session.removeAttribute("pageNo");
		return SUCCESS;
	}
	
}
