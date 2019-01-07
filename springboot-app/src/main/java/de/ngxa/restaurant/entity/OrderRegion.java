package de.ngxa.restaurant.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
//@SequenceGenerator(name = "default_gen", sequenceName = "order_region_seq", allocationSize = 1)
@Data
public class OrderRegion extends BaseEntity {

	private String country;
	private String city;
	private String district;
	private String postal;	
	
	private double price;

}
