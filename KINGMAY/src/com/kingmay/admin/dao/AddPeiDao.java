package com.kingmay.admin.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.kingmay.beans.Pei;

public class AddPeiDao {
	private SessionFactory sessionFactory;
	
	public AddPeiDao(){}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * 添加培训班
	 * @param pei
	 * @return boolean
	 * */
	public boolean AddPei(Pei pei){
		int num=0; //标识注册是否成功,0表示不成功,>0成功
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.save(pei);
//			num=Integer.parseInt(session.save(pei).toString());
//			if(num<0){
//				return false;
//			}
			transaction.commit();//写入数据库表
			session.close();
			if(pei.getPtype() != 0 && !pei.getPparent().equals("无")){
				updatePeiChild(pei.getPparent());
			}
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
			return false ;
		}
		return true;
	}
	
	/**
	 * 更新父类培训班是否有子类
	 * @param panme
	 * @return boolean
	 * */
	public boolean updatePeiChild(String pname){
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
				p.setPchild(1);
				session.update(p);
				transaction.commit();
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
}
