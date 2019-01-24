package com.axelor.main;

//import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.axelor.pojo.Account;
import com.axelor.pojo.AccountType;
import com.axelor.pojo.Client;

public class AccountMain {

	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Persist");

		EntityManager entitymanager = emfactory.createEntityManager();

		entitymanager.getTransaction().begin();

		Client client = new Client();
		client.setName("as");
		entitymanager.persist(client);

		Account acc1 = new Account(client, AccountType.DEBIT, 2000, 4.5, true);

		client.getDebitAccounts().add(acc1);
		entitymanager.persist(acc1);

		Account acc2 = new Account(client, AccountType.CREDIT, 2000, 4.5, false);

		client.getCreditAccounts().add(acc2);
		entitymanager.persist(acc2);

		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
		
		
		
		
		
//		entitymanager.flush();

		// Scanner sc=new Scanner(System.in);

		/*
		 * Client client= new Client();
		 * 
		 * System.out.println("Enter Customer id="); long cid=sc.nextLong();
		 * sc.nextLine(); System.out.println("Enter Customer name="); String
		 * cname=sc.nextLine();
		 * 
		 * 
		 * client.setId(cid); client.setName(cname);
		 * 
		 * entitymanager.persist( client );
		 * 
		 * 
		 * System.out.println("Enter number of account="); int accno=sc.nextInt();
		 * 
		 * 
		 * for(int i=0;i<accno;i++ ){
		 * 
		 * Account ac=new Account();
		 * 
		 * System.out.println("Enter Account id="); long aid=sc.nextLong();
		 * sc.nextLine(); System.out.println("Enter Account Type(debit/credit)"); String
		 * type=sc.nextLine(); System.out.println("Enter Account Amount"); double
		 * amt=sc.nextDouble(); System.out.println("Enter Account Rate"); double
		 * rate=sc.nextDouble(); System.out.println("Enter Account Active(true/false)");
		 * boolean active=sc.nextBoolean();
		 * 
		 * 
		 * 
		 * ac.setId(aid);
		 * 
		 * ac.setAmount(amt); ac.setRate(rate/100);
		 * 
		 * if(active==true){ ac.setActive(true); } else { ac.setActive(false); }
		 * ac.setClient(client);
		 * 
		 * 
		 * 
		 * 
		 * if(type.equals("debit")) {
		 * 
		 * ac.setType(AccountType.DEBIT); client.getDebitAccounts().add(ac); } else
		 * if(type.equals("credit")){
		 * 
		 * ac.setType(AccountType.CREDIT); client.getCreditAccounts().add(ac); }
		 * entitymanager.persist(ac); }
		 * 
		 * 
		 */

	}

}
