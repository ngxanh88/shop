package de.ngxa.restaurant.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
//@SequenceGenerator(name = "default_gen", sequenceName = "order_option_seq", allocationSize = 1)
@Data
public class OrderOption extends BaseEntity {

	private String name;
	private double grossBasePrice;
	private String decs;

}
