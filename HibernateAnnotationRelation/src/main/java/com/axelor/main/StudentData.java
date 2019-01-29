package com.axelor.main;



import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.axelor.pojo.Laptop;
import com.axelor.pojo.Student;

public class StudentData {

	public static final EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Persist");
	public static final EntityManager entitymanager = emfactory.createEntityManager();
	public static void main(String[] args) {
		
		entitymanager.getTransaction().begin();
		
		
		StudentData sdata=new StudentData();
		//sdata.add();
		//sdata.update();
		sdata.read();
		//sdata.delete();
		
		entitymanager.close();
		emfactory.close();
	}

	private void delete() {
		
		
		Student std=entitymanager.find(Student.class,2);
		std.getLaptops().remove(std);
		entitymanager.remove(std);
		entitymanager.getTransaction().commit();
	}

	private void read() {
		
		Student std=entitymanager.find(Student.class,2);
		System.out.println("student id= "+std.getId());
		System.out.println("student name= "+std.getSname());
	//	List<Laptop> lap=(List<Laptop>) entitymanager.createQuery("Select laptop from Student s", Laptop.class);
		
		Student person = entitymanager.find( Student.class, 1 );
		
		assertEquals(
		    "Lenovo",
		    person.getLaptops().get( 1 ).getLname()	
		);		
		
	}

	private void update() {
		// TODO Auto-generated method stub
		
	}

	private void add() {
		
		Laptop lp = new Laptop();
		lp.setLname("Dell");
		lp.setLid(3);
		
		Laptop lp2 = new Laptop();
		lp2.setLname("Mac");
		lp2.setLid(4);
		
		
		Student st = new Student();
		st.setSname("niki");
		
		lp.setStudent(st);
		lp2.setStudent(st);
		st.getLaptops().add(lp);
		
		
		entitymanager.persist(st);
		entitymanager.persist(lp);
		entitymanager.persist(lp2);
		
		

		entitymanager.getTransaction().commit();
	}
}
