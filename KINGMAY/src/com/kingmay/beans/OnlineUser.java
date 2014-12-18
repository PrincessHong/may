package com.kingmay.beans;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 在线用户
 * 
 */
public class OnlineUser {

	String ulName = "";
	
	String uName = "";
	
	String ip = "";

	String loginTime = "";

	public OnlineUser(){}
	
	public OnlineUser(String ulName, String uName , String ip , Date d){
		this.ulName = ulName;
		this.uName = uName;
		this.ip = ip;
		this.loginTime = formatDate(d);
	}
	
	public String getUlName() {
		return ulName;
	}

	public void setUlName(String ulName) {
		this.ulName = ulName;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

//	public String getSessionId() {
//		return sessionId;
//	}
//
//	public void setSessionId(String sessionId) {
//		this.sessionId = sessionId;
//	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userName=");
		builder.append(ulName);
		builder.append(", IP=");
		builder.append(ip);
		builder.append(", loginTime=");
		builder.append(loginTime);
//		builder.append(", sessionId=");
//		builder.append(sessionId);
		builder.append("]");
		return builder.toString();
	}

	public String formatDate(Date d){
		SimpleDateFormat simple_f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String s = simple_f.format(d);
		return s;
	}
}
