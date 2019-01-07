package de.ngxa.restaurant.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
//@SequenceGenerator(name = "default_gen", sequenceName = "order_line_seq", allocationSize = 1)
@Data
public class OrderLine extends BaseEntity {
	
	//for internal order
	private String itemName;
	private String itemDesc;
	private String itemNumber;	
	
	@OneToMany(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
	private List<OrderOption> options;
	
	//for external orderlines 
	private String externalItemName;
	private String externalItemDesc;
	private String externalItemNumber;
	private double externalItemPrice = 0.0;
	private int quantity = 0;
	
	@Column(nullable = false, columnDefinition = "boolean default true")
	private boolean isInternal = true;

}
