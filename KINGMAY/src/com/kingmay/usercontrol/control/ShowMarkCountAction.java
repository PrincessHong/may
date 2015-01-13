package com.kingmay.usercontrol.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.beans.MarkCount;
import com.kingmay.usercontrol.dao.UserControlDao;
import com.opensymphony.xwork2.ActionSupport;

public class ShowMarkCountAction extends ActionSupport{
	private final int pageSizemk = 10;
	private int totalPagemk;
	private int pageNomk = 0;
	private int currentPagemk  = 1;
	private UserControlDao userControlDao;
	private List<MarkCount> allList;
	private List<MarkCount> markCountList;
	
	public ShowMarkCountAction(){}
	
	
	public int getTotalPagemk() {
		return totalPagemk;
	}


	public void setTotalPagemk(int totalPagemk) {
		this.totalPagemk = totalPagemk;
	}


	public int getPageNomk() {
		return pageNomk;
	}


	public void setPageNomk(int pageNomk) {
		this.pageNomk = pageNomk;
	}


	public int getCurrentPagemk() {
		return currentPagemk;
	}


	public void setCurrentPagemk(int currentPagemk) {
		this.currentPagemk = currentPagemk;
	}


	public UserControlDao getUserControlDao() {
		return userControlDao;
	}


	public void setUserControlDao(UserControlDao userControlDao) {
		this.userControlDao = userControlDao;
	}


	public List<MarkCount> getAllList() {
		return allList;
	}


	public void setAllList(List<MarkCount> allList) {
		this.allList = allList;
	}


	public List<MarkCount> getMarkCountList() {
		return markCountList;
	}


	public void setMarkCountList(List<MarkCount> markCountList) {
		this.markCountList = markCountList;
	}


	public int getPageSizemk() {
		return pageSizemk;
	}


	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		allList = userControlDao.getMarkCount();
		if(allList.size()%pageSizemk==0){
			totalPagemk=allList.size()/pageSizemk;
		}else{
			totalPagemk=allList.size()/pageSizemk+1;
		}
		if(pageNomk <= 0){
			if(session.getAttribute("pageNomk") == null){
				pageNomk = 1;
			}else{
				pageNomk=(Integer)session.getAttribute("pageNomk");
				System.out.println("after get pageNo :"+pageNomk);
				if(pageNomk<=0){
					pageNomk = 1;
				}
			}
		}else if(pageNomk>totalPagemk){
			pageNomk=totalPagemk;
		}
		if(pageNomk>totalPagemk){
			pageNomk=totalPagemk;
		}
		markCountList = userControlDao.getMarkCountBypage(pageNomk, pageSizemk);
		currentPagemk=pageNomk;
		session.setAttribute("currentPagemk", currentPagemk);
		session.setAttribute("totalPagemk", totalPagemk);
		session.setAttribute("pageNomk", pageNomk);
		if(markCountList!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	
}

