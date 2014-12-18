package com.kingmay.admin.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.beans.Pei;
import com.kingmay.pei.dao.PeiDao;
import com.opensymphony.xwork2.ActionSupport;

public class AdminPeiAction extends ActionSupport{
	private Pei p;
	private PeiDao peiDao;
	
	public AdminPeiAction(){}

	public Pei getP() {
		return p;
	}

	public void setP(Pei p) {
		this.p = p;
	}

	public PeiDao getPeiDao() {
		return peiDao;
	}

	public void setPeiDao(PeiDao peiDao) {
		this.peiDao = peiDao;
	}

	@Override
	public String execute() throws Exception {
		if(peiDao.updatePei(p)){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	
}
