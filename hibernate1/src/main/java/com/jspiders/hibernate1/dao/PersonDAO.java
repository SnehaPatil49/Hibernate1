package com.jspiders.hibernate1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate1.dto.AdharCard;
import com.jspiders.hibernate1.dto.Person;


public class PersonDAO {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("person");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
				
	}
	private static void closeConnection() {
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
		
		Person person=new Person();
		person.setId(1);
		person.setName("Rahul");
		person.setEmail("rahul@gmail.com");
	
		
		AdharCard adharCard=new AdharCard();
		adharCard.setId(2);
		adharCard.setDateOfIssue("01/7/2000");
		adharCard.setAdharNo(234567893654l);
		entityManager.persist(adharCard);
		
		person.setAdharCard(adharCard);
		
		entityManager.persist(person);		
		
		
		entityTransaction.commit();
		closeConnection();
	}

}
