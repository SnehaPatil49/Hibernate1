package com.jspiders.hibernate1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate1.dto.EmployeeDTO;

public class EmployeeDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection()
	{
		entityManagerFactory =Persistence.createEntityManagerFactory("employee");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
		
	}
	private static void closeConnection()
	{
		if (entityManagerFactory !=null) {
			entityManagerFactory.close();
		}
		if (entityManager!=null) {
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
		emp.setId(1);
		emp.setName("Arohi");
		emp.setEmail("arohi@gmail.com");
		emp.setAddress("pune");
		emp.setContact(9857351834l);
		
		entityManager.persist(emp);
		
		
		entityTransaction.commit();
		closeConnection();
	}

}
