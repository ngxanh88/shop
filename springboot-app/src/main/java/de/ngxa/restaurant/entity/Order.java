package de.ngxa.restaurant.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ESC_ORDER")
//@SequenceGenerator(name = "default_gen", sequenceName = "order_seq", allocationSize = 1)
@Data
public class Order extends BaseEntity {

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrderLine> lines ;
	
	private Long shopId;
	private String orderNumber;
	private OrderStatus status;
	//Order Info
	private boolean isPickup = false;
	@Column(nullable = false, columnDefinition = "boolean default true")
	private boolean isInternal = true;
	private String contactName;
	private String contactPhone;
	private String contactEmail;
	private String contactAddress;
	
	private String targetShopOwnerMail;
	
	//address in details
	private String contactCity;
	private String contactPostalCode;
	private String contactStreet;
	private String contactStreetNr;
	
	private String notice;
	
	//Order Region	
	private String regionName;
	private double regionAdditionalPrice;

}
