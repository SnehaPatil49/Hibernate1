package com.jspiders.hibernate1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate1.dto.EmployeeDTO;

public class EmployeeDAO1 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection()
	{
		entityManagerFactory=Persistence.createEntityManagerFactory("employee");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
		
	}
	private static void closeConnection()
	{
		if (entityManagerFactory !=null) {
			entityManagerFactory.close();
		}
		if (entityManager !=null) {
			entityManager.close();
		}
		if (entityTransaction !=null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		EmployeeDTO emp=new EmployeeDTO();
		emp.setId(3);
		emp.setName("sneha");
		emp.setEmail("sneha@gmail.com");
		emp.setAddress("Benglore");
		emp.setContact(8956175158l);
		
		entityManager.persist(emp);
		
		EmployeeDTO emp1=new EmployeeDTO();
		emp1.setId(4);
		emp1.setName("Viraj");
		emp1.setEmail("viraj@gmail.com");
		emp1.setAddress("Mumbai");
		emp1.setContact(8956134158l);
		
		entityManager.persist(emp1);
		
		entityTransaction.commit();
		closeConnection();
	}

}
