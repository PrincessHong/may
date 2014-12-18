package com.kingmay.admin.control;

import com.kingmay.beans.Pei;
import com.kingmay.pei.dao.PeiDao;
import com.opensymphony.xwork2.ActionSupport;

public class DelPeiAction extends ActionSupport{
	private String pname;
	private PeiDao peiDao;
	
	public DelPeiAction(){}

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

	@Override
	public String execute() throws Exception {
		pname = java.net.URLDecoder.decode(pname,"UTF-8");
		Pei p = peiDao.QueryPeiByPname(pname);
		if(p.getPchild() == 1){
			return INPUT;
		}
		if(peiDao.delPei(pname)){
			peiDao.checkAndUpdateParentPei(p.getPparent());
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	
}
