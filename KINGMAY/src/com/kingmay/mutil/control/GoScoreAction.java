package com.kingmay.mutil.control;

import com.kingmay.beans.Age2;
import com.kingmay.beans.Age4;
import com.kingmay.score.dao.AgeDao;
import com.opensymphony.xwork2.ActionSupport;

public class GoScoreAction extends ActionSupport{
	private String cid;
	private AgeDao ageDao;
	private Age2 age2;
	private Age4 age4;
	
	public GoScoreAction(){}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public AgeDao getAgeDao() {
		return ageDao;
	}

	public void setAgeDao(AgeDao ageDao) {
		this.ageDao = ageDao;
	}

	public Age2 getAge2() {
		return age2;
	}

	public void setAge2(Age2 age2) {
		this.age2 = age2;
	}

	public Age4 getAge4() {
		return age4;
	}

	public void setAge4(Age4 age4) {
		this.age4 = age4;
	}

	@Override
	public String execute() throws Exception {
		cid =  java.net.URLDecoder.decode(cid,"UTF-8");
		Object o = ageDao.QueryAge(cid);
		if(o == null){
			return INPUT;
		}
		if(o instanceof Age2){
//			System.out.println("2");
			age2 = (Age2)o;
			return "age2";
		}else if(o instanceof Age4){
//			System.out.println("4");
			age4 = (Age4)o;
			return "age4";
		}else{
//			System.out.println("null");
			return INPUT;
		}
	}
	
}
