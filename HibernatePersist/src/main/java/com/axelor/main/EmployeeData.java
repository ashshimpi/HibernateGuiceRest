package com.axelor.main;

import java.util.Scanner;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.axelor.company.Employee;

public class EmployeeData {

	   public static final   EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Persist" );
	      
	    public static final  EntityManager entitymanager = emfactory.createEntityManager( );
	    	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Scanner sc=new Scanner(System.in);
			 char choice1;
					
			entitymanager.getTransaction( ).begin( );
	    		
	    	EmployeeData e=new EmployeeData();
	    		
			do {
					
	    			System.out.println("Enter the choice");
	    			int choice=sc.nextInt();
	    		
			    		switch(choice)
						{
						case 1 :e.add();
								break;
								
						case 2:e.update();
								break;
								
						case 3:e.read();
								break;
						
						case 4 :e.delete();
								break;
								
						default : System.out.println("Enter valid choice");
								break;
							
						}
			    	System.out.println("do you want to continue y or N");
			    	choice1=sc.next().charAt(0);
			    	    		
				}while(choice1 == 'Y' || choice1=='y');
	    			   
	    			//e.add();
	    		//e.update();
	    		//e.read();
	    		//e.delete();
	      	
	      entitymanager.close( );
	      emfactory.close( );
	}

	private void delete() {
		// TODO Auto-generated method stub
		 Employee employee = entitymanager.find( Employee.class, 1 );
	      entitymanager.remove( employee );
	      entitymanager.getTransaction( ).commit( );
		
	}

	private void read() {
		// TODO Auto-generated method stub

	      //Read Data
	      Employee employee = entitymanager.find( Employee.class, 2 );

	      System.out.println("employee ID = " + employee.getEid( ));
	      System.out.println("employee NAME = " + employee.getEname( ));
	      System.out.println("employee SALARY = " + employee.getSalary( ));
	      System.out.println("employee DESIGNATION = " + employee.getDeg( ));
	      
		
	}

	private void update() {
		// TODO Auto-generated method stub
		 //data update
	      Employee employee = entitymanager.find( Employee.class, 4 );
	      System.out.println( employee );
	      employee.setSalary( 2000 );
	      entitymanager.getTransaction( ).commit( );	    
	      }

	private void add() {
		// TODO Auto-generated method stub
		//data insert 
	      Employee employee = new Employee();
	      employee.setEname( "niki" );
	      employee.setSalary( 500 );
	      employee.setDeg( "Engineear" );
	      entitymanager.persist( employee );
	      entitymanager.getTransaction( ).commit( );
		}

}
