package de.ngxa.restaurant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="NGXA_SHOP_ORDER_REGION")
public class OrderRegion extends BaseEntity {

	private String country;
	private String city;
	private String district;
	private String postal;	
	
	private double price;

}
