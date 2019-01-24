package com.axelor.interest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name="simpleinterest")
public class Interest {
	
	@Id
	@GeneratedValue
	private int id;
	
	private double principle;
	private double rate;
	private double year;
	
	@Formula(value= "(principle*rate*year)/100")
	private double SI;
	
	
	public Interest() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrinciple() {
		return principle;
	}
	public void setPrinciple(double principle) {
		this.principle = principle;
		
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public double getYear() {
		return year;
	}
	public void setYear(double year) {
		this.year = year;
	}
	public double getSI() {
		return SI;
	}
	public void setSI(double sI) {
		SI = sI;
	}
	
	
	
	

}
