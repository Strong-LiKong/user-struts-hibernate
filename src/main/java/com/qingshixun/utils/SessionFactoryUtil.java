package com.qingshixun.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
	
	private static SessionFactory sessionFactory;
	
	static{
		Configuration configure=new Configuration().configure("/applicationContext.xml");
		//获取session工厂
		StandardServiceRegistryBuilder ssrb=new StandardServiceRegistryBuilder();
		StandardServiceRegistry serviceRegistry=ssrb.applySettings(configure.getProperties()).build();
		sessionFactory=configure.buildSessionFactory(serviceRegistry);
	}
	
	//获取session对象
	public static Session getSession(){
		return sessionFactory.openSession();
	}
}
