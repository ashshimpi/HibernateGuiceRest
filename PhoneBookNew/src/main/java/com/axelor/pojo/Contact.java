package com.axelor.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Contact {

	@GeneratedValue
	public int id;
	public String cname;
	public int cnumber;
	
	public Contact() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCnumber() {
		return cnumber;
	}
	public void setCnumber(int cnumber) {
		this.cnumber = cnumber;
	}
	
}
