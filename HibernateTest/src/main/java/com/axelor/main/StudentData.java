package com.axelor.main;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.axelor.pojo.Laptop;
import com.axelor.pojo.Student;

public class StudentData {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Persist");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Laptop lp = new Laptop();
		lp.setLname("hp");
		ArrayList<Laptop> laptopList=new ArrayList<>();
		
		
		Student st = new Student();
		st.setSname("as");
		lp.setStudent(st);
		laptopList.add(lp);
		st.setLaptops(laptopList);
		
		
		entitymanager.persist(st);
		entitymanager.persist(lp);
		
		

		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}
}
