package de.ngxa.restaurant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="NGXA_SHOP_ORDER_LINE_OPTION")
public class OrderOption extends BaseEntity {

	private String name;
	private double grossBasePrice;
	private String decs;

}
