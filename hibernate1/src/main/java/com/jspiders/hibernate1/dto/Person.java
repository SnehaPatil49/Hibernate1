package com.jspiders.hibernate1.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;


@Data
@Entity
public class Person {

	@Id
	private int id;
	private String name;
	private String email;
	@OneToOne
	private AdharCard adharCard;
}
