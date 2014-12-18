package com.kingmay.pei.control;

import java.util.List;

import com.kingmay.beans.Pei;
import com.kingmay.pei.dao.PeiDao;
import com.opensymphony.xwork2.ActionSupport;

public class QueryPeiAction extends ActionSupport{
	private PeiDao peiDao;
	private List<Pei> peilist;
	
	public QueryPeiAction(){}
	
	public List<Pei> getPeilist() {
		return peilist;
	}

	public void setPeilist(List<Pei> peilist) {
		this.peilist = peilist;
	}

	public PeiDao getPeiDao() {
		return peiDao;
	}
	public void setPeiDao(PeiDao peiDao) {
		this.peiDao = peiDao;
	}
	@Override
	public String execute() throws Exception {
		peilist = peiDao.QueryParentPei();
		
		if(peilist == null){
			System.out.println("enter peilist == null");
			return SUCCESS;
		}
		
		if(peilist.size() > 0 ){
//			for(Pei p : peilist){
//				System.out.println(p.getPname());
//			}
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	
	
}
