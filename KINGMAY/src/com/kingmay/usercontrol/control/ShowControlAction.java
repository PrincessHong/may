package com.kingmay.usercontrol.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.beans.UserControl;
import com.kingmay.usercontrol.dao.UserControlDao;
import com.opensymphony.xwork2.ActionSupport;

public class ShowControlAction extends ActionSupport{
	private final int pageSizeuc = 10;
	private int totalPageuc;
	private int pageNouc = 0;
	private int currentPageuc  = 1;
	private UserControlDao userControlDao;
	private List<UserControl> allList;
	private List<UserControl> userControlList;
	
	public ShowControlAction(){}

	public int getTotalPageuc() {
		return totalPageuc;
	}



	public void setTotalPageuc(int totalPageuc) {
		this.totalPageuc = totalPageuc;
	}



	public int getPageNouc() {
		return pageNouc;
	}



	public void setPageNouc(int pageNouc) {
		this.pageNouc = pageNouc;
	}



	public int getCurrentPageuc() {
		return currentPageuc;
	}



	public void setCurrentPageuc(int currentPageuc) {
		this.currentPageuc = currentPageuc;
	}



	public UserControlDao getUserControlDao() {
		return userControlDao;
	}



	public void setUserControlDao(UserControlDao userControlDao) {
		this.userControlDao = userControlDao;
	}



	public List<UserControl> getAllList() {
		return allList;
	}



	public void setAllList(List<UserControl> allList) {
		this.allList = allList;
	}



	public List<UserControl> getUserControlList() {
		return userControlList;
	}



	public void setUserControlList(List<UserControl> userControlList) {
		this.userControlList = userControlList;
	}



	public int getPageSizeuc() {
		return pageSizeuc;
	}



	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		allList = userControlDao.getUserControl();
		if(allList.size()%pageSizeuc==0){
			totalPageuc=allList.size()/pageSizeuc;
		}else{
			totalPageuc=allList.size()/pageSizeuc+1;
		}
		if(pageNouc <= 0){
			if(session.getAttribute("pageNouc") == null){
				pageNouc = 1;
			}else{
				pageNouc=(Integer)session.getAttribute("pageNouc");
				System.out.println("after get pageNo :"+pageNouc);
				if(pageNouc<=0){
					pageNouc = 1;
				}
			}
		}else if(pageNouc>totalPageuc){
			pageNouc=totalPageuc;
		}
		if(pageNouc>totalPageuc){
			pageNouc=totalPageuc;
		}
		userControlList = userControlDao.getUserControlBypage(pageNouc, pageSizeuc);
		currentPageuc=pageNouc;
		session.setAttribute("currentPageuc", currentPageuc);
		session.setAttribute("totalPageuc", totalPageuc);
		session.setAttribute("pageNouc", pageNouc);
		if(userControlList!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	
}
