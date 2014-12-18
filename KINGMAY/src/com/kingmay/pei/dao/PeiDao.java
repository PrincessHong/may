package com.kingmay.pei.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.kingmay.beans.Pei;

public class PeiDao {
	public PeiDao(){}
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 查询省培训班
	 * @return List<Pei>
	 * */
	public List<Pei> QueryParentPei(){
		Session session=null;
		List<Pei> newlist = new ArrayList<Pei>();
		try{
			session=sessionFactory.openSession();
			String queryString="from Pei where ptype=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0,0);
			List<Pei> list=queryObject.list();
			session.close();
			
			if(list.size() < 0 ){
				return null;
			}else{
				for(int i = 0; i < list.size() ; i++ ){
					newlist.add(list.get(i));
					if(list.get(i).getPchild() == 1){
						List<Pei> l = QueryChildPei(list.get(i).getPname());
						newlist.addAll(l);
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return newlist;
	}
	
	/**
	 * 查询市培训班
	 * @return List<Pei>
	 * @param pname
	 * */
	public List<Pei> QueryChildPei(String pname){
		Session session=null;
		List<Pei> newlist = new ArrayList<Pei>();
		try{
			session=sessionFactory.openSession();
			String queryString="from Pei where ptype=? and pparent=? order by pname desc";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0,1);
			queryObject.setParameter(1,pname);
			List<Pei> list=queryObject.list();
			session.close();
			if(list.size() < 0){
				return null;
			}else{
				for(int i = 0; i < list.size() ; i++ ){
					newlist.add(list.get(i));
					if(list.get(i).getPchild() == 1){
						List<Pei> l = QueryPei(list.get(i).getPname());
						newlist.addAll(l);
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return newlist;
	}
	
	/**
	 * 查询培训班
	 * @return List<Pei>
	 * @param pname
	 * */
	public List<Pei> QueryPei(String pname){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Pei where ptype=? and pparent=? order by pname desc";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0,2);
			queryObject.setParameter(1,pname);
			List<Pei> list=queryObject.list();
			session.close();
			if(list.size() < 0){
				return null;
			}else{
				return list;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 通过培训班名查询省培训班
	 * @param pname
	 * @return Pei
	 * */
	public Pei QueryPeiByPname(String pname){
		Session session=null;
		List<Pei> newlist = new ArrayList<Pei>();
		try{
			session=sessionFactory.openSession();
			String queryString="from Pei where pname=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0,pname);
			List<Pei> list=queryObject.list();
			if(list.size() > 0){
				return (Pei)list.get(0);
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 通过培训班名删除培训班
	 * @param pname
	 * @return boolean
	 * */
	public boolean delPei(String pname){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Pei where pname=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, pname);
			List<Pei> list=queryObject.list();
			Pei p=list.get(0);
			transaction=session.beginTransaction();
			session.delete(p);//在缓存中保存数据，受影响行数
			transaction.commit();//写入数据库表
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 通过培训班名修改培训班信息
	 * @param pname
	 * @return boolean
	 * */
	public boolean adminPei(String pname){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Pei where pname=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, pname);
			List<Pei> list=queryObject.list();
			Pei p=list.get(0);
			transaction=session.beginTransaction();
			session.delete(p);//在缓存中保存数据，受影响行数
			transaction.commit();//写入数据库表
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 修改培训班信息
	 * @param pei
	 * @return boolean
	 * */
	public boolean updatePei(Pei pei){
		Session session=null;
		Transaction transaction=null;
		boolean change = false;
		String useit = null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			String queryString="from Pei where pid=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, pei.getPid());
			List<Pei> l = queryObject.list();
			System.out.println("update Pei list size-->" + l.size() + pei.getPid());
			if(l.size() == 1){
				Pei p = (Pei)l.get(0);
				if(!p.getPparent().equals(pei.getPparent())){
					change = true;
					useit = p.getPparent();
				}
				Pei parent = QueryPeiByPname(pei.getPparent());
				if(parent.getPtype() > pei.getPtype()){
					return false;
				}
				p.setPchild(pei.getPchild());
				p.setPname(pei.getPname());
				p.setPnotify(pei.getPnotify());
				p.setPparent(pei.getPparent());
				p.setPshunxu(pei.getPshunxu());
				p.setPstate(pei.getPstate());
				p.setPstm(pei.getPstm());
				p.setPtype(pei.getPtype());
				session.update(p);
				transaction.commit();
				checkAndUpdateParentPei(pei.getPparent());
				if(change){
					checkAndUpdateParentPei(useit);
				}
				return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false ;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 修改培训班信息后检查父类是否null或无，如果是检查父类是否有子类，无则改pchild为0
	 * @param pparent
	 * */
	public void checkAndUpdateParentPei(String pparent){
		System.out.println("enter check and update parent pei");
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			String queryString="from Pei where pparent=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, pparent);
			List<Pei> l = queryObject.list();
			System.out.println("the lise size is -->" + l.size());
			if(l.size() > 0){
				updateParentPei(pparent, 1);
			}else{
				updateParentPei(pparent, 0);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	private void updateParentPei(String pname,int type){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			String queryString="from Pei where pname=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, pname);
			List<Pei> l = queryObject.list();
			if(l.size() == 1){
				Pei p = (Pei)l.get(0);
				p.setPchild(type);	
				session.update(p);
				transaction.commit();
			}else{
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}
