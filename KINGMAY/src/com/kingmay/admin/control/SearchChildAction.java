package com.kingmay.admin.control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.kingmay.beans.Child;
import com.kingmay.score.dao.AgeDao;
import com.opensymphony.xwork2.ActionSupport;

public class SearchChildAction extends ActionSupport{
	private String search_id;
	private String search_name;
	private AgeDao ageDao;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	private List<Child> childs = new ArrayList<Child>();
	
	public SearchChildAction(){}

	public String getSearch_id() {
		return search_id;
	}

	public void setSearch_id(String search_id) {
		this.search_id = search_id;
	}

	public String getSearch_name() {
		return search_name;
	}

	public void setSearch_name(String search_name) {
		this.search_name = search_name;
	}

	public AgeDao getAgeDao() {
		return ageDao;
	}

	public void setAgeDao(AgeDao ageDao) {
		this.ageDao = ageDao;
	}

	public List<Child> getChilds() {
		return childs;
	}

	public void setChilds(List<Child> childs) {
		this.childs = childs;
	}

	@Override
	public String execute() throws Exception {
		search_id = java.net.URLDecoder.decode(search_id,"UTF-8");
		search_name = java.net.URLDecoder.decode(search_name,"UTF-8");
		if(search_id == null){
			search_id = "";
		}
		if(search_name == null){
			search_name = "";
		}
		childs = ageDao.SearchChildById_Name(search_id, search_name);
		return SUCCESS;
	}
	
	
}
