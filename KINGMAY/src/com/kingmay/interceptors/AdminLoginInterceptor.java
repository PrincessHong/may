package com.kingmay.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.beans.Admin;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminLoginInterceptor extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation ai) throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Admin a = (Admin) session.getAttribute("admin");
		if(a != null){
			return ai.invoke();
		}
		else{
			ActionContext ac=ai.getInvocationContext();
			return "adminlogin";
		}
	}

}
