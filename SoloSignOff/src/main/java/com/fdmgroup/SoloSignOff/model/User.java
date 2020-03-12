package com.fdmgroup.SoloSignOff.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="S_USER")
@NamedQueries({ @NamedQuery(name = "userFindAll", query = "SELECT u FROM User u"),
	@NamedQuery(name = "userFindById", query = "SELECT u FROM User u WHERE u.userId = :userId"),
	@NamedQuery(name = "userListId", query = "SELECT u.userId FROM User u") })

public class User {
	
	@Id
	@Column(name = "USER_ID", length = 4, nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_gen")
	@SequenceGenerator(name = "user_id_gen", sequenceName = "user_id_seq", allocationSize = 1)
	private int userId;
	
	@Column(name = "FIRST_NAME", length = 30)
	private String firstName;
	
	@Column(name = "LAST_NAME", length = 30)
	private String lastName;
	
	@Column(name = "BALANCE", length = 15, nullable = false)
	private int balance;
	
	
	public User(String firstName, String lastName, int balance) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}
	
	public User() {
		super();
	}

	public int getId() {
		return userId;
	}

	public void setId(int id) {
		this.userId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [id=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", balance=" + balance + "]";
	}
	
	

}
