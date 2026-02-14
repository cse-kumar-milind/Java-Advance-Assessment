package com.employeeIdCard.management;

import jakarta.persistence.*;

@Entity
public class Employee {
	@Id
	private int id;
	
	private String name;
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "idCard_id")
	private IdCard idCard;
	
	public Employee() {
	}

	public Employee(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}

	@Override
	public String toString() {
		return "Employee Details:\nid: " + id + "\nname: " + name + "\nemail: " + email;
	}
	
	
	
	
	
}
