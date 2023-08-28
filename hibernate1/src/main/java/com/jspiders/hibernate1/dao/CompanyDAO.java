package com.jspiders.hibernate1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate1.dto.Company;
import com.jspiders.hibernate1.dto.Employee;

public class CompanyDAO {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection()
	{
		entityManagerFactory=Persistence.createEntityManagerFactory("alpha");
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
		
		Company company=new Company();
		company.setId(1);
		company.setName("Google");
		company.setEmail("google@gmail.com");
		company.setAddress("Pune");
		
		Employee emp1=new Employee();
		emp1.setId(1);
		emp1.setName("Rohit");
		emp1.setEmail("rohit@gmail.com");
		emp1.setSalary(25000.00);
		
		Employee emp2=new Employee();
		emp2.setId(2);
		emp2.setName("Rohini");
		emp2.setEmail("rohini@gmail.com");
		emp2.setSalary(35000.00);
		
		Employee emp3=new Employee();
		emp3.setId(3);
		emp3.setName("Arya");
		emp3.setEmail("arya@gmail.com");
		emp3.setSalary(50000.00);
		
		List<Employee> employee = new ArrayList();
		employee.add(emp1);
		employee.add(emp2);
		employee.add(emp3);
		
		company.setEmployee(employee);
		
		entityManager.persist(emp1);
		entityManager.persist(emp2);
		entityManager.persist(emp3);
		entityManager.persist(company);
		
		entityTransaction.commit();
		closeConnection();
	}

}
