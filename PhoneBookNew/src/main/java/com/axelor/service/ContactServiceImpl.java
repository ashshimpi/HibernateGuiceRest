package com.axelor.service;

import javax.persistence.EntityManager;
import com.axelor.pojo.*;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public abstract class ContactServiceImpl implements ContactService{

	
	@Inject
	public EntityManager em;

	@Transactional
	public void add(Object user) {
		//System.out.println("data not inserted");
		em.persist(user);
		//System.out.println("data inserted");
	}
	
	

}
