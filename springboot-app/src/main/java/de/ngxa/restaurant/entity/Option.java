package de.ngxa.restaurant.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ESC_OPTION")
//@SequenceGenerator(name = "default_gen", sequenceName = "option_seq", allocationSize = 1)
@Data
public class Option extends BaseEntity {

	private String name;
	private double grossBasePrice;
	private String decs;
	private String identifier;

}
