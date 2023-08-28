package com.jspiders.hibernate1.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class AdharCard {
	
	@Id
	private int id;
	private String dateOfIssue;
	private long adharNo;

}
