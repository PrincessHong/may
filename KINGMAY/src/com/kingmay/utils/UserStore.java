package com.kingmay.utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kingmay.beans.OnlineUser;


/**
 * �����û��Ự�洢��
 * 
 */
public class UserStore {

	/**
	 * {sessionId: OnlineUser} �����û�����
	 */
	private static Map<String, OnlineUser> onlineUsers = new HashMap<String, OnlineUser>();


	/**
	 * ��ȡ��ǰ�ڴ��������û��б�
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
	 * ��ȡ�û�
	 * 
	 * @param userName
	 */
	public static OnlineUser getUser(String userName) {
		return onlineUsers.get(userName);
	}

	/**
	 * ����û�
	 * 
	 * @param user
	 */
	public static void addUser(OnlineUser user) {
		if (user != null && !exist(user.getUlName())) {
			onlineUsers.put(user.getUlName(), user);
		}
	}

	/**
	 * ɾ���û�
	 * 
	 * @param userName
	 */
	public static void delUser(String userName) {
		onlineUsers.remove(userName);
	}

	/**
	 * �ж��Ƿ���ڸ��û�
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
	 * �õ���ʵ��IP��ַ
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
