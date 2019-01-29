package com.axelor.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="laptop")
public class Laptop {
	
	@Id
	@GeneratedValue
	private int lid;
	
	private String lname;
	//@OneToOne(mappedBy="laptop")
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	
/*	
	public Laptop(int lid, String lname) {
		
		this.lid = lid;
		this.lname = lname;
	}
	*/
	
	
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



	public Student getStudent() {
		return student;
	}



	public void setStudent(Student student) {
		this.student = student;
	}
	
	

}
