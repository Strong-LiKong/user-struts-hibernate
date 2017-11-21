package com.qingshixun.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qingshixun.model.Page;
import com.qingshixun.model.User;

@Repository("userDao") // spring 注解，申明这是一个持久层（dao 层）
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveorUpdataUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	public void deleteUser(Long userId) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.get(User.class, userId));
	}

	public User getUserById(Long userId) {
		Session session = sessionFactory.getCurrentSession();
		return (User) session.get(User.class, userId);
	}

	public List<User> getUserListByPage(int page, int pageSize,String nameString) {
		Session session = sessionFactory.getCurrentSession();
		String hql="";
		if("".equals(nameString)|| nameString==null){
			hql="from User order by id desc";
		}
		else{
			hql="from User where userName like '%"+nameString+"%'";
		}
		Query query = session.createQuery(hql);
		query.setFirstResult((page - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<User> list = query.list();
		return list;
	}

	public int getTotalNumberOfUser(String nameString) {
		Session session = sessionFactory.getCurrentSession();
		String hql="";
		if("".equals(nameString)|| nameString==null){
			hql="select count(*) from User";
		}
		else{
			hql="select count(*) from User where userName like '%"+nameString+"%'";
		}
		Query query = session.createQuery(hql);
		return ((Long) query.iterate().next()).intValue();
	}
	
	public int getNumberOfMale(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(*) from User where gender = '男'");
		return ((Long) query.iterate().next()).intValue();
	}
	
	public List getlineData(){
		Session session = sessionFactory.getCurrentSession();
		SQLQuery  query= session.createSQLQuery("SELECT u.cdate,count(*) FROM (SELECT left(createDate,11) cdate FROM db_user) u GROUP BY u.cdate");  
		List list= query.list(); 
		return list;
	}
	
}
