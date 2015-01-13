package com.kingmay.usercontrol.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kingmay.beans.MarkCount;
import com.kingmay.beans.UserControl;

public class UserControlDao {

	private SessionFactory sessionFactory;
	
	public UserControlDao(){}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	/**
	 * 显示所有用户操作
	 * @return List<UserControl>
	 * */
	public List<UserControl> getUserControl(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from UserControl";
			Query queryObject=session.createQuery(queryString);
			List<UserControl> users=queryObject.list();
			return users;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 分页显示所有用户操作
	 * @return List<UserControl>
	 * */
	public List<UserControl> getUserControlBypage(int pageNo,int pageSize){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from UserControl";
			Query queryObject=session.createQuery(queryString);
			queryObject.setFirstResult((pageNo-1)*pageSize);
			queryObject.setMaxResults(pageSize);
			List<UserControl> users=queryObject.list();
			return users;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 显示所有用户操作
	 * @return List<MarkCount>
	 * */
	public List<MarkCount> getMarkCount(){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from MarkCount";
			Query queryObject=session.createQuery(queryString);
			List<MarkCount> users=queryObject.list();
			return users;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 分页显示所有用户操作
	 * @return List<MarkCount>
	 * */
	public List<MarkCount> getMarkCountBypage(int pageNo,int pageSize){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from MarkCount";
			Query queryObject=session.createQuery(queryString);
			queryObject.setFirstResult((pageNo-1)*pageSize);
			queryObject.setMaxResults(pageSize);
			List<MarkCount> users=queryObject.list();
			return users;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
}
