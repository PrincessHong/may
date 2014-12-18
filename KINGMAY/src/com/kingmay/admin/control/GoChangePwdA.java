package com.kingmay.admin.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.admin.dao.UserDao;
import com.kingmay.beans.Admin;
import com.opensymphony.xwork2.ActionSupport;

public class GoChangePwdA extends ActionSupport{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	private Admin a ;
	private String oldpwd;
	private String newpwd;
	private String regpwd;
	private UserDao userDao;
	public Admin getA() {
		return a;
	}
	public void setA(Admin a) {
		this.a = a;
	}
	
	public String getOldpwd() {
		return oldpwd;
	}
	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getRegpwd() {
		return regpwd;
	}
	public void setRegpwd(String regpwd) {
		this.regpwd = regpwd;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public String execute() throws Exception {
		a = (Admin) session.getAttribute("admin");
		if(a == null){
			return INPUT;
		}
		if(!a.getApwd().equals(oldpwd)){
			request.setAttribute("msg_a", "æ…√‹¬Î¥ÌŒÛ£¨«Î÷ÿ–¬ ‰»Î");
			return INPUT;
		}
		
		if(userDao.updateAPwd(a.getAid(), newpwd)){
			a.setApwd(newpwd);
			session.setAttribute("admin", a);
			return SUCCESS;
		}else{
			return INPUT;
		}
			
	}
	
	
	
}
