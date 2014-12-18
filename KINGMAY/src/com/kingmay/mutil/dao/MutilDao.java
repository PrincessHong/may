package com.kingmay.mutil.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kingmay.beans.User;


public class MutilDao {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 显示所有主试
	 * @return List<User>
	 * */
	public List<User> QueryAllUser(){
		List<User> list;
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from User";
			Query queryObject=session.createQuery(queryString);
			list=queryObject.list();
			if(list.size() < 0){
				return null;
			}else{
				return list;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 显示分页所有主试
	 * @return List<User>
	 * */
	public List<User> getUserBypage(int pageNo,int pageSize){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from User";
			Query queryObject=session.createQuery(queryString);
			queryObject.setFirstResult((pageNo-1)*pageSize);
			queryObject.setMaxResults(pageSize);
			List<User> users=queryObject.list();
			return users;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
}
