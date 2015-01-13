package com.kingmay.user.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.admin.dao.UserDao;
import com.kingmay.beans.User;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeQueAction extends ActionSupport{
	private String ans;
	private String ans1;
	private String que;
	private UserDao userDao;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	User u = (User)session.getAttribute("user");
	
	public ChangeQueAction(){}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public String getAns1() {
		return ans1;
	}

	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}

	public String getQue() {
		return que;
	}

	public void setQue(String que) {
		this.que = que;
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
		if((ans1==null || ans1.equals("")) && (que.equals("")||que == null)){
			return INPUT;
		}
		if(userDao.updateUserQue(u.getUid(), que, ans1)){
//			System.out.println("----");
			u.setUque(que);
			u.setUans(ans1);
			session.setAttribute("user", u);
			return SUCCESS;
		}else{
//			System.out.println("====");
			return INPUT;
		}
	}

	@Override
	public void validate() {
		if(ans==null || ans.equals("")){
			addFieldError("ans","答案必填");
		}
		if(!u.getUans().equals(ans)){
			addFieldError("ans","答案错误");
		}
		if((ans1==null || ans1.equals("")) && (!que.equals("")||que != null) ){
			addFieldError("ans1","新答案必填");
		}
		if((ans1!=null || !ans1.equals("")) && (que.equals("")||que == null) ){
			addFieldError("que","新问题必填");
		}
	}
}
