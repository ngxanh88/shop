package de.ngxa.restaurant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="NGXA_SHOP_ORDER_LINE")
public class OrderLine extends BaseEntity {
	
	//for internal order
	private String itemName;
	private String itemDesc;
	private String itemNumber;
	
	@OneToMany(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="order_line_id", referencedColumnName="id")
	private List<OrderOption> options = new ArrayList<>();
	
	//for external orderlines 
	private String externalItemName;
	private String externalItemDesc;
	private String externalItemNumber;
	private double externalItemPrice = 0.0;
	private int quantity = 0;
	
	@Column(nullable = false, columnDefinition = "boolean default true")
	private boolean isInternal = true;

}
