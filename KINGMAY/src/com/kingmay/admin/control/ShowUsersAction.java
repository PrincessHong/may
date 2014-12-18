package com.kingmay.admin.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.admin.dao.UserDao;
import com.kingmay.beans.User;
import com.opensymphony.xwork2.ActionSupport;

public class ShowUsersAction extends ActionSupport{
	private List<User> userlist;
	private UserDao userDao;
	private final int pageSize = 15;
	private int totalPage;
	private int pageNo = 0;
	private int currentPage  = 1;
	private List<User> alllist;
	
	public ShowUsersAction(){}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<User> getAlllist() {
		return alllist;
	}

	public void setAlllist(List<User> alllist) {
		this.alllist = alllist;
	}

	public int getPageSize() {
		return pageSize;
	}

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		alllist = userDao.QueryAllUser();
		if(alllist.size()%pageSize==0){
			totalPage=alllist.size()/pageSize;
		}else{
			totalPage=alllist.size()/pageSize+1;
		}
		if(pageNo <= 0){
			if(session.getAttribute("pageNo") == null){
				pageNo = 1;
			}else{
				pageNo=(Integer)session.getAttribute("pageNo");
				System.out.println("after get pageNo :"+pageNo);
				if(pageNo<=0){
					pageNo = 1;
				}
			}
		}else if(pageNo>totalPage){
			pageNo=totalPage;
		}
		if(pageNo>totalPage){
			pageNo=totalPage;
		}
		userlist = userDao.getUserBypage(pageNo, pageSize);
		currentPage=pageNo;
		session.setAttribute("currentPage", currentPage);
		session.setAttribute("totalPage", totalPage);
		session.setAttribute("pageNo", pageNo);
		if(userlist!=null){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
