package de.ngxa.restaurant.dto;

import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseDto {
	
	private Long id;
	
	private Date modifiedDate;
	
	private Date createDate = new Date();
}