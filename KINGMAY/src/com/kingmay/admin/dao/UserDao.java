package com.kingmay.admin.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.kingmay.beans.Admin;
import com.kingmay.beans.Age2;
import com.kingmay.beans.Age4;
import com.kingmay.beans.Child;
import com.kingmay.beans.Pei;
import com.kingmay.beans.User;

public class UserDao {
	private SessionFactory sessionFactory;
	public UserDao() {
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * 添加主试
	 * @param user
	 * @return boolean
	 * */
	public boolean AddUser(User user){
		int num=0; //标识注册是否成功,0表示不成功,>0成功
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.save(user).toString();
			if(num<0){
				return false;
			}
			transaction.commit();//写入数据库表
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
			return false ;
		}finally{
			session.close();
		}
		return true;
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
	
	/**
	 * 通过id查询主试
	 * @param uid
	 * @return User
	 * */
	public User QueryUserByUid(String uid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from User where uid=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, uid);
			List<User> list=queryObject.list();
			if(list.size() == 1){
				return list.get(0);
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
	 * 通过id删除主试
	 * @param uid
	 * @return boolean
	 * */
	public boolean delUserByUid(String uid){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from User where uid=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, uid);
			List<User> list=queryObject.list();
			User u = list.get(0);
			transaction=session.beginTransaction();
			session.delete(u);
			transaction.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 修改主试信息
	 * @param user
	 * @return boolean
	 * */
	public boolean updateUser(User user){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			String queryString="from User where uid=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, user.getUid());
			List<User> l = queryObject.list();
			if(l.size() == 1){
				User u = (User)l.get(0);
				u.setUlpwd(user.getUlpwd());
				u.setUque(user.getUque());
				u.setUans(user.getUans());
				u.setUbei(user.getUbei());
				u.setUbir(user.getUbir());
				u.setUcanuse(user.getUcanuse());
				u.setUused(user.getUused());
				u.setUcom(user.getUcom());
				u.setUcomadd(user.getUcomadd());
				u.setUemail(user.getUemail());
				u.setUicq(user.getUicq());
				u.setUiden(user.getUiden());
				u.setUip(user.getUip());
				u.setUmsn(user.getUmsn());
				u.setUname(user.getUname());
				u.setUpei(user.getUpei());
				u.setUqq(user.getUqq());
				u.setUquan(user.getUquan());
				u.setUren(user.getUren());
				u.setUsex(user.getUsex());
				u.setUstm(user.getUstm());
				u.setUtel(user.getUtel());
				session.update(u);
				transaction.commit();
				return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return  false;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 用户登录
	 * @param ulname 
	 * @param ulpwd
	 * @return user
	 * */
	public User UserLogin(String ulname, String ulpwd){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from User where ulname=? and ulpwd=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, ulname);
			queryObject.setParameter(1, ulpwd);
			List<User> list=queryObject.list();
			if(list.size() == 1){
				return list.get(0);
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
	 * 修改用户密码
	 * @param uid 
	 * @param ulpwd
	 * @return boolean
	 * */
	public boolean updateUserPwd(String uid, String ulpwd){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			String queryString="from User where uid=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, uid);
			List<User> l = queryObject.list();
			if(l.size() == 1){
				User u = (User)l.get(0);
				u.setUlpwd(ulpwd);
				session.update(u);
				transaction.commit();
				return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return  false;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 修改用户问题、答案
	 * @param uid 
	 * @param uque
	 * @param uans
	 * @return boolean
	 * */
	public boolean updateUserQue(String uid, String uque , String uans){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			String queryString="from User where uid=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, uid);
			List<User> l = queryObject.list();
			if(l.size() == 1){
				User u = (User)l.get(0);
				u.setUque(uque);
				u.setUans(uans);
				session.update(u);
				transaction.commit();
				return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return  false;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 用户维护个人信息
	 * @param uid 
	 * @param uemail
	 * @param utel
	 * @param ucom
	 * @return boolean
	 * */
	public boolean updateUserInfo(String uid, String uemail , String utel ,String ucom){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			String queryString="from User where uid=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, uid);
			List<User> l = queryObject.list();
			if(l.size() == 1){
				User u = (User)l.get(0);
				u.setUemail(uemail);
				u.setUtel(utel);
				u.setUcom(ucom);
				session.update(u);
				transaction.commit();
				return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return  false;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 用户维护个人信息
	 * @param user
	 * */
	public void updateUserLastTime(User user){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			session.update(user);
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	/**
	 * 用户添加测试儿童
	 * @param child
	 * @return boolean
	 * */
	public boolean addChild(Child child){
		int num=0; //标识注册是否成功,0表示不成功,>0成功
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
//			num=Integer.parseInt(session.save(child).toString());
			session.save(child);
//			if(num<0){
//				return false;
//			}
			transaction.commit();//写入数据库表
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
			return false ;
		}finally{
			session.close();
		}
//		return true;
	}
	
	/**
	 * 用户修改儿童
	 * @param child
	 * @return boolean
	 * */
	public boolean updateChild(Child child , int type){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			String queryString="from Child where cid=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, child.getCid());
			List<Child> l = queryObject.list();
			if(l.size() == 1){
				Child c = (Child)l.get(0);
				c.setCctime(child.getCctime());
				c.setCurl(child.getCurl());
				c.setCuid(child.getCuid());
				c.setCanchange(type);
				session.update(c);
				transaction.commit();
				return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return  false;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 用户通过id查询儿童
	 * @param cid
	 * @return Child
	 * */
	public Child QueryChildById(String cid){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from Child where cid=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, cid);
			List<Child> l = queryObject.list();
			if(l.size() == 1){
				return l.get(0);
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return  null;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 通过cid删除age
	 * @param cid
	 * @return Child
	 * */
	public boolean delAgeByCid(String cid,int type){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			String queryString = "";
			if(type == 0){
				queryString="from Age2 where cid=?";
			}else{
				queryString="from Age4 where cid=?";
			}
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, cid);
			List<Object> list=queryObject.list();
			Object o = list.get(0);
			transaction=session.beginTransaction();
			if(type == 0){
				session.delete((Age2)o);
			}else{
				session.delete((Age4)o);
			}
			transaction.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 用户忘记密码
	 * @param ulname
	 * @return User
	 * */
	public User ForgetPwd(String ulname){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String queryString="from User where ulname=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, ulname);
			List<User> l = queryObject.list();
			if(l.size() == 1){
				return l.get(0);
			}else{
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return  null;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 用户忘记密码后修改
	 * @param ulname
	 * @param pwd
	 * @return boolean
	 * */
	public boolean updateUlPwd(String ulname ,String pwd){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			String queryString="from User where ulname=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, ulname);
			List<User> l = queryObject.list();
			if(l.size() == 1){
				User u = (User)l.get(0);
				u.setUlpwd(pwd);
				session.update(u);
				transaction.commit();
				return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return  false;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 用户忘记密码后修改
	 * @param ulname
	 * @param pwd
	 * @return boolean
	 * */
	public boolean updateAPwd(int i ,String pwd){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			String queryString="from Admin where aid=?";
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, i);
			List<Admin> l = queryObject.list();
			if(l.size() == 1){
				Admin a = (Admin)l.get(0);
				a.setApwd(pwd);
				session.update(a);
				transaction.commit();
				return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return  false;
		}finally{
			session.close();
		}
	}
}