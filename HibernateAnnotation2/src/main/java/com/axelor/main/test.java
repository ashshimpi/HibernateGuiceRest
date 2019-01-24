package com.axelor.main;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.axelor.pojo.Account;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Persist");

		EntityManager entitymanager = emfactory.createEntityManager();

		entitymanager.getTransaction().begin();
		
		List<Account> accounts=entitymanager.createQuery("select * from Account a",Account.class).getResultList();
		assertEquals(0, accounts.size());
		
		entitymanager.close();
		emfactory.close();
	}

}
