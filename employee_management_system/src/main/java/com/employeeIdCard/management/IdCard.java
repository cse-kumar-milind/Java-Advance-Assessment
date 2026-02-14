package com.employeeIdCard.management;

import jakarta.persistence.*;

@Entity
public class IdCard {
	@Id
	private int id;
	
	private String cardNumber;
	private String date;
	
	@OneToOne(mappedBy = "idCard", fetch = FetchType.LAZY)
	private Employee employee;
	
	public IdCard() {
		// TODO Auto-generated constructor stub
	}

	

	public IdCard(int id, String cardNumber, String date, Employee employee) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.date = date;
		this.employee = employee;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "IdCard Details:\nCardNumber: " + cardNumber + "\nIssue date: " + date;
	}

	
	
	
	

}
