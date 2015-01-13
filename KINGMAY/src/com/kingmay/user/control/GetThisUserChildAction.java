package com.kingmay.user.control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


import com.kingmay.beans.Child;
import com.kingmay.beans.User;
import com.kingmay.score.dao.AgeDao;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class GetThisUserChildAction extends ActionSupport{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	private User u;
	private List<Child> childs = new ArrayList<Child>();
	private AgeDao ageDao;
	private final int pageSiz = 5;
	private int totalPag;
	private int pageN = 0;
	private int currentPag  = 1;
	
	public GetThisUserChildAction(){}
	
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	
	public List<Child> getChilds() {
		return childs;
	}

	public void setChilds(List<Child> childs) {
		this.childs = childs;
	}

	public AgeDao getAgeDao() {
		return ageDao;
	}

	public void setAgeDao(AgeDao ageDao) {
		this.ageDao = ageDao;
	}
	

	public int getTotalPag() {
		return totalPag;
	}

	public void setTotalPag(int totalPag) {
		this.totalPag = totalPag;
	}

	public int getPageN() {
		return pageN;
	}

	public void setPageN(int pageN) {
		this.pageN = pageN;
	}

	public int getCurrentPag() {
		return currentPag;
	}

	public void setCurrentPag(int currentPag) {
		this.currentPag = currentPag;
	}

	public int getPageSiz() {
		return pageSiz;
	}

	@Override
	public String execute() throws Exception {
		u = (User)session.getAttribute("user");
		request.setAttribute("que", u.getUque());
		List<Child> alllist = ageDao.QueryAllChild(u);
		if(alllist.size()%pageSiz==0){
			totalPag=alllist.size()/pageSiz;
		}else{
			totalPag=alllist.size()/pageSiz+1;
		}
		if(pageN <= 0){
			if(session.getAttribute("pageN") == null){
				pageN = 1;
			}else{
				pageN=(Integer)session.getAttribute("pageN");
//				System.out.println("after get pageNo :"+pageN);
				if(pageN<=0){
					pageN = 1;
				}
			}
		}else if(pageN>totalPag){
			pageN=totalPag;
		}
		if(pageN>totalPag){
			pageN=totalPag;
		}
		childs = ageDao.getChildBypage(pageN, pageSiz,u);
		currentPag=pageN;
		session.setAttribute("currentPage", currentPag);
		session.setAttribute("totalPage", totalPag);
		session.setAttribute("pageNo", pageN);
		return SUCCESS;
	}
	
	
}
