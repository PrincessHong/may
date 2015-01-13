package com.kingmay.admin.control;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.kingmay.admin.dao.UserDao;
import com.kingmay.beans.MarkCount;
import com.kingmay.beans.User;
import com.kingmay.utils.UserStore;
import com.opensymphony.xwork2.ActionSupport;

public class AdminUserAction extends ActionSupport{
	private User u;
	private UserDao userDao;
	private int adduse;
	private int reduce;
	private int adduse4;
	private int reduce4;
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public int getAdduse() {
		return adduse;
	}
	public void setAdduse(int adduse) {
		this.adduse = adduse;
	}
	
	public int getReduce() {
		return reduce;
	}
	public void setReduce(int reduce) {
		this.reduce = reduce;
	}
	public int getAdduse4() {
		return adduse4;
	}
	public void setAdduse4(int adduse4) {
		this.adduse4 = adduse4;
	}
	public int getReduce4() {
		return reduce4;
	}
	public void setReduce4(int reduce4) {
		this.reduce4 = reduce4;
	}
	@Override
	public String execute() throws Exception {
		int ucanuse_old = u.getUcanuse();
		int ucanuse_old4 = u.getUcanuse4();
		int ucanuse_new = 0;
		int ucanuse_new4 = 0;
		String s = "";
//		System.out.println("ucanuse ->"+ucanuse_old +" ucanuse4->"+ucanuse_old4);
		if(adduse > 0 || adduse4 > 0 || reduce > 0 || reduce4 > 0){
			if(adduse > 0){
				ucanuse_new = ucanuse_old + adduse;
				s += "【2:6-3:11岁】原值：【"+ucanuse_old+"份】，现增加【"+adduse+"】份=【"+ucanuse_new+"】份。";
				u.setUcanuse(ucanuse_new);
			}
			if(adduse4 > 0){
				ucanuse_new4 = ucanuse_old4 + adduse4;
				s += "【4:0-6:11岁】原值：【"+ucanuse_old4+"份】，现增加【"+adduse4+"】份=【"+ucanuse_new4+"】份。";
				u.setUcanuse4(ucanuse_new4);
			}
			if(reduce > 0){
				ucanuse_new = ucanuse_old - reduce;
				s += "【2:6-3:11岁】原值：【"+ucanuse_old+"份】，现减少【"+reduce+"】份=【"+ucanuse_new+"】份。";
				u.setUcanuse(ucanuse_new);
			}
			if(reduce4 > 0){
				ucanuse_new4 = ucanuse_old4 - reduce4;
				s += "【4:0-6:11岁】原值：【"+ucanuse_old4+"份】，现减少【"+reduce4+"】份=【"+ucanuse_new4+"】份。";
				u.setUcanuse4(ucanuse_new4);
			}
			HttpServletRequest request = ServletActionContext.getRequest();
			MarkCount mk = new MarkCount();
			mk.setUid(u.getUid());
			mk.setMip(UserStore.getIpAddr(request));
			mk.setMtime(UserStore.formatDate(new Date()));
			mk.setMcontent(s);
			userDao.AddMarkCount(mk);
			
		}
//		System.out.println("ucanuse new ->"+ucanuse_new +" ucanuse4 new->"+ucanuse_new4);
		if(userDao.updateUser(u)){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
}
