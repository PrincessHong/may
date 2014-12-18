package com.kingmay.score.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.kingmay.beans.Age2;
import com.kingmay.beans.Age4;
import com.kingmay.beans.Child;
import com.kingmay.beans.User;

public class AgeDao {
	
	private SessionFactory sessionFactory;
	
	public AgeDao(){}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	/**
	 * 显示自己所有列表
	 * @return List<User>
	 * */
	public List<Child> QueryAllChild(User u){
		List<Child> list;
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Child where cuid=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, u.getUid());
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
	 * 显示分页所有儿童
	 * @return List<User>
	 * */
	public List<Child> getChildBypage(int pageNo,int pageSize,User u){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Child where cuid=? order by cctime desc";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, u.getUid());
			queryObject.setFirstResult((pageNo-1)*pageSize);
			queryObject.setMaxResults(pageSize);
			List<Child> childs=queryObject.list();
			return childs;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 显示自己所有列表
	 * @return List<User>
	 * */
	public List<Child> QueryChild(){
		List<Child> list;
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Child";
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
	 * 显示分页所有儿童
	 * @return List<User>
	 * */
	public List<Child> getChildpage(int pageNo,int pageSize){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Child";
			Query queryObject=session.createQuery(queryString);
			queryObject.setFirstResult((pageNo-1)*pageSize);
			queryObject.setMaxResults(pageSize);
			List<Child> childs=queryObject.list();
			return childs;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	
	/**
	 * 获取当前列的成绩
	 * @return List<Object>
	 * */
	public List<Object> QueryAge(List<Child> list){
		List<Object> list_o = new ArrayList<Object>();
		Session session=null;
		List<Object> list_l = new ArrayList<Object>();
		try{
			for(int i = 0 ; i< list.size() ; i++){
				session=sessionFactory.openSession();
				String queryString="from Age2 where cid=?";
				Query queryObject=session.createQuery(queryString);
				queryObject.setParameter(0, list.get(i).getCid());
				list_l=queryObject.list();
				session.close();
				if(list_l.size() < 1 || list_l == null){
					System.out.println("=== "+list.get(i).getCid());
					session=sessionFactory.openSession();
					queryString="from Age4 where cid=?";
					queryObject=session.createQuery(queryString);
					queryObject.setParameter(0, list.get(i).getCid());
					list_l=queryObject.list();
					session.close();
					if(list_l.size() == 1){
						list_o.add(list_l.get(0));
					}
				}else{
					if(list_l.size() == 1){
						list_o.add(list_l.get(0));
					}
				}
			}
			return list_o;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void addAge2(Age2 a){
		int num=0; //标识注册是否成功,0表示不成功,>0成功
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(a).toString());
			if(num<0){
				return ;
			}
			transaction.commit();//写入数据库表
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
			return ;
		}finally{
			session.close();
		}
	}
	
	public void addAge4(Age4 a){
		int num=0; //标识注册是否成功,0表示不成功,>0成功
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			num=Integer.parseInt(session.save(a).toString());
			if(num<0){
				return ;
			}
			transaction.commit();//写入数据库表
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
			return ;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 获取原始分数
	 * @return List<Object>
	 * */
	public Object QueryAge(String cid){
		List<Object> list_o = new ArrayList<Object>();
		Session session=null;
		List<Object> list_l = new ArrayList<Object>();
		try{
				session=sessionFactory.openSession();
				String queryString="from Age2 where cid=?";
				Query queryObject=session.createQuery(queryString);
				queryObject.setParameter(0, cid);
				list_l=queryObject.list();
				session.close();
				if(list_l.size() < 1 || list_l == null){
					session=sessionFactory.openSession();
					queryString="from Age4 where cid=?";
					queryObject=session.createQuery(queryString);
					queryObject.setParameter(0, cid);
					list_l=queryObject.list();
					session.close();
					if(list_l.size() == 1){
						list_o.add(list_l.get(0));
					}
				}else{
					if(list_l.size() == 1){
						list_o.add(list_l.get(0));
					}
				}
			return list_o.get(0);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
