package com.axelor.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;

@Entity(name = "Client")
public class Client {

	@Id
	@GeneratedValue
	public Long id;
	public String name;

	@Where(clause = "account_type = 'DEBIT'")
	@OneToMany(mappedBy = "client")
	private List<Account> debitAccounts = new ArrayList<>();

	@Where(clause = "account_type = 'CREDIT'")
	@OneToMany(mappedBy = "client")
	private List<Account> creditAccounts = new ArrayList<>();

	/*public Client(String name, List<Account> debitAccounts, List<Account> creditAccounts) {
		this.name = name;
		this.debitAccounts = debitAccounts;
		this.creditAccounts = creditAccounts;
	}
*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getDebitAccounts() {
		return debitAccounts;
	}

	public void setDebitAccounts(List<Account> debitAccounts) {
		this.debitAccounts = debitAccounts;
	}

	public List<Account> getCreditAccounts() {
		return creditAccounts;
	}

	public void setCreditAccounts(List<Account> creditAccounts) {
		this.creditAccounts = creditAccounts;
	}

}
