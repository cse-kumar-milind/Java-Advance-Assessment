package com.employeeIdCard.management;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeManager");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Employee employee1 = new Employee(103,"Chandan", "chandan@gmail.com");
		
		em.persist(employee1);
		
		IdCard ic1 = new IdCard(103,"IDC101","15-Sep-2022", employee1);
		
		employee1.setIdCard(ic1);
		
		em.persist(ic1);
		
		em.getTransaction().commit();
		
		
		IdCard ic = em.find(IdCard.class, 103);
		
		System.out.println(ic.getEmployee());
		
		System.out.println();
		
		Employee employee = em.find(Employee.class, 103);
		
		System.out.println(employee.getIdCard());
		
	}

}
