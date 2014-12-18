package com.kingmay.user.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.admin.dao.UserDao;
import com.kingmay.beans.Child;
import com.kingmay.beans.User;
import com.opensymphony.xwork2.ActionSupport;

public class addChildAction extends ActionSupport{
	private Child c;
	private UserDao userDao;
	private String type;
	
	public addChildAction(){}

	public Child getC() {
		return c;
	}

	public void setC(Child c) {
		this.c = c;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		
		if(u.getUcanuse()- u.getUused() <=0){
			return INPUT;
		}
		
		int year,month,day,ctyear,ctmonth,ctday,cbyear,cbmonth,cbday;
		ctyear = c.getCtyear();
		ctmonth = c.getCtmonth();
		ctday = c.getCtday();
		cbyear = c.getCbyear();
		cbmonth = c.getCbmonth();
		cbday = c.getCbday();
		if(ctday < cbday){
			ctmonth--;
			ctday += 30;
			if(ctmonth <= 0){
				ctyear--;
				ctmonth += 12;
			}
		}
		day = ctday - cbday;
		if(ctmonth < cbmonth){
			ctyear--;
			ctmonth += 12;
		}
		month = ctmonth - cbmonth;
		year = ctyear - cbyear;
		
		//¶ùÍ¯±àºÅÉèÖÃ
		String ccid = "";
		int ucanused = u.getUused()+1;
		String uuid = u.getUid();
		ccid = uuid+"000"+ucanused;
		if(ucanused >= 10 && ucanused <100){
			ccid = uuid+"00"+ucanused;
		}else if(ucanused >= 100 && ucanused <1000){
			ccid = uuid+"0"+ucanused;
		}else if(ucanused >= 1000){
			ccid = uuid+""+ucanused;
		}
		c.setCid(ccid);
		
		c.setCyear(year);
		c.setCmonth(month);
		c.setCday(day);
		session.setAttribute("child",c);
		if(userDao.addChild(c)){
			if(year>=4){
				return "success4";
			}else{
				return SUCCESS;
			}
		}else{
			if(type.equals("1")){
				return INPUT;
			} else if(type.equals("4")){
				return "input4";
			}
		}
		return SUCCESS;
	}
	
}
