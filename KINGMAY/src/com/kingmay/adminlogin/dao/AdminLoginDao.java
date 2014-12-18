package com.kingmay.adminlogin.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.kingmay.beans.Admin;
import com.kingmay.beans.User;

public class AdminLoginDao {
	private SessionFactory sessionFactory;
	public AdminLoginDao(){}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * 后台管理员登录
	 * @param name
	 * @param pwd
	 * @return Admin
	 * */
	public Admin AdminLogin(String name , String pwd){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Admin where aName=? and aPwd=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, name);
			queryObject.setParameter(1, pwd);
			List<Admin> list=queryObject.list();
			if(list.size()>0){
				return list.get(0);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}
}
