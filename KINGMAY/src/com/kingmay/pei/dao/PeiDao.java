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
	 * ��ѯʡ��ѵ��
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
	 * ��ѯ����ѵ��
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
	 * ��ѯ��ѵ��
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
	 * ͨ����ѵ������ѯʡ��ѵ��
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
	 * ͨ����ѵ����ɾ����ѵ��
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
			session.delete(p);//�ڻ����б������ݣ���Ӱ������
			transaction.commit();//д�����ݿ��
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	/**
	 * ͨ����ѵ�����޸���ѵ����Ϣ
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
			session.delete(p);//�ڻ����б������ݣ���Ӱ������
			transaction.commit();//д�����ݿ��
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	/**
	 * �޸���ѵ����Ϣ
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
	 * �޸���ѵ����Ϣ���鸸���Ƿ�null���ޣ�����Ǽ�鸸���Ƿ������࣬�����pchildΪ0
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
