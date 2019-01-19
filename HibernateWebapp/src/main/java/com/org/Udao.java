package com.org;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
public class Udao {
	
	public static int register(User u){  
		int i=0;  
		org.hibernate.boot.registry.StandardServiceRegistry ssr = new org.hibernate.boot.registry.StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction(); 
		
		i=(Integer)session.save(u);  

		t.commit();  
		session.close();  
		  
		return i;  
		
		}
}


