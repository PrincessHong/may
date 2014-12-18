package com.kingmay.admin.control;

import com.kingmay.admin.dao.AddPeiDao;
import com.kingmay.beans.Pei;
import com.kingmay.pei.dao.PeiDao;
import com.opensymphony.xwork2.ActionSupport;

public class AddPeiAction extends ActionSupport{
	private Pei p;
	private AddPeiDao addPeiDao;
	private PeiDao peiDao;
	public AddPeiAction(){}
	public Pei getP() {
		return p;
	}
	public void setP(Pei p) {
		this.p = p;
	}
	public AddPeiDao getAddPeiDao() {
		return addPeiDao;
	}
	public void setAddPeiDao(AddPeiDao addPeiDao) {
		this.addPeiDao = addPeiDao;
	}
	
	public PeiDao getPeiDao() {
		return peiDao;
	}
	public void setPeiDao(PeiDao peiDao) {
		this.peiDao = peiDao;
	}
	@Override
	public String execute() throws Exception {
		System.out.println(p.getPname()+p.getPchild()+p.getPnotify()+p.getPshunxu()+p.getPtype());
		if(p.getPtype() == 4 ){
			return INPUT;
		}
		if(!p.getPparent().equals("нч")){
			Pei pp = peiDao.QueryPeiByPname(p.getPparent());
			if(pp.getPtype() >= p.getPtype()){
				return INPUT;
			}
		}
		if(addPeiDao.AddPei(p)){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	
}
