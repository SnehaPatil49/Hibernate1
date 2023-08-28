package com.jspiders.hibernate1.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity

public class EmployeeDTO {
	@Id
	private int id;
	private String name;
	private String address;
	private String email;
	private long contact;

}
