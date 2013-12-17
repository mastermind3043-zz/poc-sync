package com.noobsoft.morpheus.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.noobsoft.morpheus.domain.User;

public class HibernateTest {
private static  SessionFactory sessionFactory;
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure();
		ServiceRegistry serviceRegistry= new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(new User("Monids", "Dextr"));
		session.getTransaction().commit();
		session.flush();
		session.close();
		
		
	}

}
