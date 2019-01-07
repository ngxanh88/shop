package de.ngxa.restaurant.entity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "order_option_seq", allocationSize = 1)
public class OrderOption extends BaseEntity{

	private static final long serialVersionUID = 1L;
	private String name;
	private double grossBasePrice;
	private String decs;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGrossBasePrice() {
		return grossBasePrice;
	}
	public void setGrossBasePrice(double grossBasePrice) {
		this.grossBasePrice = grossBasePrice;
	}
	public String getDecs() {
		return decs;
	}
	public void setDecs(String decs) {
		this.decs = decs;
	}	
	
	
	
	
}
