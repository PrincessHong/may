package com.kingmay.user.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.admin.dao.UserDao;
import com.kingmay.beans.User;
import com.opensymphony.xwork2.ActionSupport;

public class ChangePwdAction extends ActionSupport{
	private UserDao userDao;
	private String pwd;
	private String pwd1;
	private String pwd2;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	User u = (User)session.getAttribute("user");
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwd1() {
		return pwd1;
	}
	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}
	public String getPwd2() {
		return pwd2;
	}
	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}
	@Override
	public String execute() throws Exception {
		if(userDao.updateUserPwd(u.getUid(), pwd1)){
			u.setUlpwd(pwd1);
			session.setAttribute("user", u);
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	@Override
	public void validate() {
		if(pwd==null || pwd.equals("")){
			addFieldError("pwd","√‹¬Î±ÿÃÓ");
		}
		if(pwd1==null || pwd1.equals("")){
			addFieldError("pwd1","√‹¬Î±ÿÃÓ");
		}
		if(pwd2==null || pwd2.equals("")){
			addFieldError("pwd2","»∑»œ√‹¬Î±ÿÃÓ");
		}
		if(!u.getUlpwd().equals(pwd)){
			addFieldError("pwd","√‹¬Î¥ÌŒÛ");
		}
		if(!pwd2.equals(pwd1)){
			addFieldError("pwd1","√‹¬Î≤ª“ª÷¬");
		}
	}
	
	
}
