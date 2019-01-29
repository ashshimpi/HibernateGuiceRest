package com.axelor.main;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.axelor.pojo.Employee;

public class EmployeeDAO {

	public void addUserDetails(String ename, String salary, String dept) {
        try {
            // 1. configuring hibernate
            Configuration configuration = new Configuration().configure();
 
            // 2. create sessionfactory
            SessionFactory sessionFactory = configuration.buildSessionFactory();
 
            // 3. Get Session object
            Session session = sessionFactory.openSession();
 
            // 4. Starting Transaction
            Transaction transaction = session.beginTransaction();
           Employee emp=new Employee(ename, salary, dept);
            
            session.save(emp);
            transaction.commit();
            System.out.println("\n\n Details Added \n");
            System.out.println(""+ename);
 
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
 
	}
	public void viewdeatils() {
        try {
            // 1. configuring hibernate
            Configuration configuration = new Configuration().configure();
 
            // 2. create sessionfactory
            SessionFactory sessionFactory = configuration.buildSessionFactory();
 
            // 3. Get Session object
            Session session = sessionFactory.openSession();
 
            // 4. Starting Transaction
            Transaction t = session.beginTransaction();

            Query query = session.createQuery("from EMPLOYEE");
            java.util.List list = query.list();
            for (int i = 0; i < list.size(); i++) {
            	   Employee emp = (Employee)list.get(i);
            	  }
            System.out.println(list);
            t.commit();
           
            
           
 
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
 
	}
}