package com.axelor.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Laptop {
	
	@Id
	
	private int lid;
	private String lname;
	
	
	public Laptop(int lid, String lname) {
		
		this.lid = lid;
		this.lname = lname;
	}
	
	
	
	public Laptop() {
		
	}



	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	

}
