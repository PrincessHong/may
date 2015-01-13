package com.kingmay.adminlogin.control;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts2.ServletActionContext;

import com.kingmay.adminlogin.dao.AdminLoginDao;
import com.kingmay.beans.Admin;
import com.kingmay.beans.OnlineUser;
import com.kingmay.utils.UserStore;
import com.kingmay.utils.ValidataCode;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLoginAction extends ActionSupport{
	public AdminLoginAction(){}
	private AdminLoginDao adminLoginDao;
	private String aName ,aPwd;
	private Admin aa;
	private String validataCode;
	
	public Admin getAa() {
		return aa;
	}
	public void setAa(Admin aa) {
		this.aa = aa;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public String getaPwd() {
		return aPwd;
	}
	public void setaPwd(String aPwd) {
		this.aPwd = aPwd;
	}
	public AdminLoginDao getAdminLoginDao() {
		return adminLoginDao;
	}
	public void setAdminLoginDao(AdminLoginDao adminLoginDao) {
		this.adminLoginDao = adminLoginDao;
	}
	
	
	public String getValidataCode() {
		return validataCode;
	}
	public void setValidataCode(String validataCode) {
		this.validataCode = validataCode;
	}
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
//		Admin ad = admin/LoginDao.AdminLogin(aName,aPwd);
		Admin ad = adminLoginDao.AdminLogin(aa.getAname(), aa.getApwd());
//		System.out.println("add");
		if(null == ad){
//			addFieldError("managerName", "用户不存在或密码错误");
			return INPUT;
		}
		session.setAttribute("admin", ad);
		
		String ip = UserStore.getIpAddr(request);
		OnlineUser onlineUser = new OnlineUser(ad.getAname(), "京美管理员", ip, new Date());
		if(UserStore.exist(ad.getAname())){
			UserStore.delUser(ad.getAname());
			UserStore.addUser(onlineUser);
		}else{
			UserStore.addUser(onlineUser);
		}
		
		if(ad.getAauth().toString().equals("0")){
			return "success0";
		}
		return "success1";
	}
	
	@Override
	public void validate() {
		Admin ad = adminLoginDao.AdminLogin(aa.getAname(), aa.getApwd());
		boolean isValidata = ValidataCode.verification(validataCode);
		HttpServletRequest request = ServletActionContext.getRequest();
//		System.out.println(validataCode+"验证码"+isValidata);
//		System.out.println(validataCode+"验证码"+isValidata);
		HttpSession session = request.getSession();
		if (isValidata == false) {
			request.setAttribute("msg","验证码输入错误，请重新输入！");
			request.getRequestDispatcher("/login.jsp");
		} else if(null == ad){
			request.setAttribute("msg","登录失败,请验证账号或者密码是否正确");
			request.getRequestDispatcher("/manager/login.jsp");
		}
	}
	
	
	
}
