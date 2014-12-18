package com.kingmay.admin.control;

import java.util.List;

import com.kingmay.beans.OnlineUser;
import com.kingmay.utils.UserStore;
import com.opensymphony.xwork2.ActionSupport;

public class OnlineUserAction extends ActionSupport{
	private List<OnlineUser> onlineUserList = null;
	
	public OnlineUserAction(){}

	public List<OnlineUser> getOnlineUserList() {
		return onlineUserList;
	}

	public void setOnlineUserList(List<OnlineUser> onlineUserList) {
		this.onlineUserList = onlineUserList;
	}

	@Override
	public String execute() throws Exception {
		onlineUserList = UserStore.getOnlineUsers();
		if(onlineUserList != null){
			System.out.println(""+onlineUserList.size());
		}
		return SUCCESS;
	}
	
	
}
