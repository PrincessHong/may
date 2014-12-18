package com.kingmay.mutil.control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.beans.Child;
import com.kingmay.beans.User;
import com.kingmay.score.dao.AgeDao;
import com.opensymphony.xwork2.ActionSupport;

public class BackChildAction extends ActionSupport{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	private List<Child> childs = new ArrayList<Child>();
	private AgeDao ageDao;
	private final int pageSiz = 15;
	private int totalPa;
	private int page = 0;
	private int currentPa  = 1;
	
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
	public int getTotalPa() {
		return totalPa;
	}
	public void setTotalPa(int totalPa) {
		this.totalPa = totalPa;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getCurrentPa() {
		return currentPa;
	}
	public void setCurrentPa(int currentPa) {
		this.currentPa = currentPa;
	}
	public int getPageSiz() {
		return pageSiz;
	}
	@Override
	public String execute() throws Exception {
		List<Child> alllist = ageDao.QueryChild();
		if(alllist.size()%pageSiz==0){
			totalPa=alllist.size()/pageSiz;
		}else{
			totalPa=alllist.size()/pageSiz+1;
		}
		if(page <= 0){
			if(session.getAttribute("page") == null){
				page = 1;
			}else{
				page=(Integer)session.getAttribute("page");
				System.out.println("after get pageNo :"+page);
				if(page<=0){
					page = 1;
				}
			}
		}else if(page>totalPa){
			page=totalPa;
		}
		if(page>totalPa){
			page=totalPa;
		}
		childs = ageDao.getChildpage(page, pageSiz);
		currentPa=page;
		session.setAttribute("currentPage", currentPa);
		session.setAttribute("totalPage", totalPa);
		session.setAttribute("pageNo", page);
		session.setAttribute("childs", childs);
		return SUCCESS;
	}
	
	
	
}
