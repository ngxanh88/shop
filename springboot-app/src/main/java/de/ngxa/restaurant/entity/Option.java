package de.ngxa.restaurant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="NGXA_MENU_GROUP_OPTION_ITEM")
public class Option extends BaseEntity {

	private String name;
	private double grossBasePrice;
	private String decs;
	private String identifier;

}
