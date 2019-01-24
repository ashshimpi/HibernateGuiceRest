package com.axelor.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.axelor.pojo.Laptop;
import com.axelor.pojo.Student;



public class StudentData {

	public static void main(String[] args) {
		EntityManagerFactory emfactory= Persistence.createEntityManagerFactory("Persist");
		EntityManager  entitymanager=emfactory.createEntityManager();
		
		entitymanager.getTransaction().begin();
		
			

		Laptop lp =new Laptop();
		lp.setLname("hp");
		lp.setLid(102);
		
		entitymanager.persist( lp );
		
		Student  st =new Student();
		st.setSname("asb");
		st.setLaptop(lp);
		
		entitymanager.persist( st );
	
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
		

		
		
	}

}
