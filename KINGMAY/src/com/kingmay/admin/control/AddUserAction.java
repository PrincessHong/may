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
	private int reduce;
	private int adduse4;
	private int reduce4;
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
	
	public int getReduce() {
		return reduce;
	}
	public void setReduce(int reduce) {
		this.reduce = reduce;
	}
	public int getAdduse4() {
		return adduse4;
	}
	public void setAdduse4(int adduse4) {
		this.adduse4 = adduse4;
	}
	public int getReduce4() {
		return reduce4;
	}
	public void setReduce4(int reduce4) {
		this.reduce4 = reduce4;
	}
	@Override
	public String execute() throws Exception {
		u.setUcanuse(adduse+u.getUcanuse());
		u.setUcanuse4(adduse4+u.getUcanuse4());
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
