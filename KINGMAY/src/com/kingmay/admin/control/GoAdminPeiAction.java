package com.kingmay.admin.control;

import com.kingmay.beans.Pei;
import com.kingmay.pei.dao.PeiDao;
import com.opensymphony.xwork2.ActionSupport;

public class GoAdminPeiAction extends ActionSupport{
	private String pname;
	private PeiDao peiDao;
	private Pei p;
	
	public GoAdminPeiAction(){}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public PeiDao getPeiDao() {
		return peiDao;
	}

	public void setPeiDao(PeiDao peiDao) {
		this.peiDao = peiDao;
	}

	public Pei getP() {
		return p;
	}

	public void setP(Pei p) {
		this.p = p;
	}

	@Override
	public String execute() throws Exception {
		pname = java.net.URLDecoder.decode(pname,"UTF-8");
		System.out.println("pname-->"+pname);
		p = peiDao.QueryPeiByPname(pname);
		if(p!=null){
			this.setP(p);
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
}
