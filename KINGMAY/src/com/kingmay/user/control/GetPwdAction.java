package com.kingmay.user.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.beans.User;
import com.opensymphony.xwork2.ActionSupport;

public class GetPwdAction extends ActionSupport{
	private String ans;
	private User u ;
	
	public GetPwdAction(){}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("ans-->"+ans +" u.getuans-->"+u.getUans());
		if(u.getUans().equals(ans)){
			return SUCCESS;
		}else{
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			request.setAttribute("ansErrorMsg","答案错误，请重新输入");
			request.getRequestDispatcher("/forget.jsp");
			return INPUT;
		}
	}
	
	
}
