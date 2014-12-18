package com.kingmay.user.control;

import java.io.InputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.admin.dao.UserDao;
import com.kingmay.beans.Age4;
import com.kingmay.beans.Child;
import com.kingmay.beans.User;
import com.kingmay.pdf.Create4pdf;
import com.kingmay.score.dao.AgeDao;
import com.opensymphony.xwork2.ActionSupport;

public class CanChange4Action extends ActionSupport{
	private Age4 age;
	public String url;
	public UserDao userDao;
	private AgeDao ageDao;
	
	public CanChange4Action(){}

	public Age4 getAge() {
		return age;
	}

	public void setAge(Age4 age) {
		this.age = age;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public AgeDao getAgeDao() {
		return ageDao;
	}

	public void setAgeDao(AgeDao ageDao) {
		this.ageDao = ageDao;
	}
	
	public InputStream getInputStream() throws Exception{
		return ServletActionContext.getServletContext().getResourceAsStream(url);
	}
	
	public String getDownloadFileName(){
		String downFileName = url.substring(url.lastIndexOf("/")+1);
		System.out.println("ÎÄ¼þ£º"+downFileName);
		try{
			downFileName = new String(downFileName.getBytes(),"ISO8859-1");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return downFileName;
		
	}

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Child c = (Child) session.getAttribute("child");
		User u = (User) session.getAttribute("user");
		
		userDao.delAgeByCid(c.getCid(), 1);
		
		Age4 a = new Age4(age.getBd(),age.getInf(),age.getMr(), age.getBs(),age.getSp(),age.getPm() ,age.getSi(),age.getPc(),age.getCa(),age.getZl(),age.getOa() ,age.getAc() ,age.getRv(), age.getPn(), age.getCar(), age.getCas(), age.getSsp(),age.getBjjc(), age.getJsff() ,age.getQsjsff(),c);
		a.setCid(c.getCid());
		Create4pdf pdf = new Create4pdf();
		url = pdf.Create4pdf(a, c);
		String s = u.setlast(new Date());
		c.setCctime(s);
		c.setCurl(url);
		c.setCuid(u.getUid());
		userDao.updateChild(c,1);
		session.removeAttribute("child");
		ageDao.addAge4(a);
		return super.execute();
	}
	

}
