package com.axelor.main;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.axelor.interest.Interest;

public class InterestData {
	
	public static final	EntityManagerFactory emfactory= Persistence.createEntityManagerFactory("Persist");
	public static final	EntityManager  entitymanager=emfactory.createEntityManager();
	
	public static void main(String[] args) {
		
		
		
		entitymanager.getTransaction().begin();
		
		InterestData idata =new InterestData();
		
		//idata.add();
		idata.read();
		
		
		entitymanager.close();
		emfactory.close();
		

	}

	private void read() {
	
		try {
			Interest simple=entitymanager.find(Interest.class, 2);

			System.out.println("total salary "+simple.getSI());
			
		} 
		catch(NullPointerException ex)
		{
			System.out.println("data is not availble");
		}
		
	}

	private void add() {
		
		
		
		Interest i=new Interest();
		i.setPrinciple(5000);
		i.setRate(4.5);
		i.setYear(2);
		entitymanager.persist( i );
		entitymanager.getTransaction( ).commit( );
		
		
	
				
	
		
	}
	
	

}
