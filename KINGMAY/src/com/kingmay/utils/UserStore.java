package com.kingmay.utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kingmay.beans.OnlineUser;


/**
 * 在线用户会话存储类
 * 
 */
public class UserStore {

	/**
	 * {sessionId: OnlineUser} 在线用户缓存
	 */
	private static Map<String, OnlineUser> onlineUsers = new HashMap<String, OnlineUser>();


	/**
	 * 获取当前内存中在线用户列表
	 * 
	 * @return
	 */
	public static List<OnlineUser> getOnlineUsers() {
		List<OnlineUser> list = new ArrayList<OnlineUser>();
		for (String key : onlineUsers.keySet()) {
			list.add(onlineUsers.get(key));
		}
		return list;
	}

	/**
	 * 获取用户
	 * 
	 * @param userName
	 */
	public static OnlineUser getUser(String userName) {
		return onlineUsers.get(userName);
	}

	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	public static void addUser(OnlineUser user) {
		if (user != null && !exist(user.getUlName())) {
			onlineUsers.put(user.getUlName(), user);
		}
	}

	/**
	 * 删除用户
	 * 
	 * @param userName
	 */
	public static void delUser(String userName) {
		onlineUsers.remove(userName);
	}

	/**
	 * 判断是否存在该用户
	 * 
	 * @param userName
	 * @return
	 */
	public static boolean exist(String userName) {
		if (onlineUsers.containsKey(userName)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 得到真实的IP地址
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
	       String ip = request.getHeader("x-forwarded-for");
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	           ip = request.getHeader("Proxy-Client-IP");
	       }
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	           ip = request.getHeader("WL-Proxy-Client-IP");
	       }
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	           ip = request.getRemoteAddr();
	       }
	       return ip;
	}
}
