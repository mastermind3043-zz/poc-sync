package com.noobsoft.morpheus.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateFactory {

	private static SessionFactory sessionFactory;
	private static Configuration cfg;
	private static ServiceRegistry serviceRegistry;
	private static Session genericSession;
	
	private void buildSessionFactory(){
		cfg = new Configuration().configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);
	}
	
	public HibernateFactory buildIfNeeded(){
		if(sessionFactory==null || sessionFactory.isClosed()) {
			
			buildSessionFactory();
		}
		
		return this;
	}
	
	
	public Session freshSession(){
		return	sessionFactory.openSession();
	}
	
	public Session getSession(){
		
		if(genericSession == null ){
			genericSession = sessionFactory.openSession();
		}
		//ADD CHECKS FOR SESSION STATE
		
		return genericSession;
	}
}
