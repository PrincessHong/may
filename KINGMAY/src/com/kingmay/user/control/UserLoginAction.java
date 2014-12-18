package com.kingmay.user.control;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.admin.dao.UserDao;
import com.kingmay.beans.Admin;
import com.kingmay.beans.OnlineUser;
import com.kingmay.beans.User;
import com.kingmay.utils.UserStore;
import com.opensymphony.xwork2.ActionSupport;

public class UserLoginAction extends ActionSupport{
	private User u;
	private UserDao userDao;
	
	public UserLoginAction(){}

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

	@Override
	public String execute() throws Exception {
		User uu = userDao.UserLogin(u.getUlname(), u.getUlpwd());
		if(uu != null){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			uu.setUlast(uu.setlast(new Date()));
			userDao.updateUserLastTime(uu);
			session.setAttribute("user", uu);
			
			String ip = UserStore.getIpAddr(request);
			OnlineUser onlineUser = new OnlineUser(uu.getUlname(), uu.getUname(), ip, new Date());
			if(UserStore.exist(uu.getUlname())){
				UserStore.delUser(uu.getUlname());
				UserStore.addUser(onlineUser);
			}else{
				UserStore.addUser(onlineUser);
			}
			
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	@Override
	public void validate() {
		User uu = userDao.UserLogin(u.getUlname(), u.getUlpwd());
		if(null == uu){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			request.setAttribute("msg","登录失败,请验证账号或者密码是否正确");
			request.getRequestDispatcher("/login.jsp");
		}
	}
	
}
