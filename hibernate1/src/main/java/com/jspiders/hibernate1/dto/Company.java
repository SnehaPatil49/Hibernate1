package com.jspiders.hibernate1.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.*;
import lombok.Data;

@Data
@Entity

public class Company {
	
	@Id
	private int id;
	private String name;
	private String email;
	private String address;
	@OneToMany
	private List<Employee> employee;

}
