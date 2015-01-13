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
		
		int sum2 = u.getUcanuse() + u.getUused();
		int sum4 = u.getUcanuse4() + u.getUused4();
		
		
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
		
		if(year >= 4){
			if( sum4 - u.getUused4() <=0){
				System.out.println("次数不够");
				return INPUT;
			}
		}else{
			if(sum2 - u.getUused() <=0){
				System.out.println("次数不够");
				return INPUT;
			}
		}
		
		
		//儿童编号设置
		String ccid = "";
		String uuid = u.getUid();
		int ucanused = u.getUused()+1;
		if(year >= 4){
			ucanused = u.getUused4()+1;
			uuid = uuid+"4";
		}else{
			uuid = uuid+"2";
		}
		ccid = uuid+"000"+ucanused;
		
		System.out.println("ccid -->"+ccid);
		
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
		System.out.println("c child id "+c.getCid());
		
		
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
