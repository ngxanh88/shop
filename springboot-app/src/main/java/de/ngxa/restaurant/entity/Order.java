package de.ngxa.restaurant.entity;

import de.ngxa.restaurant.constant.OrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="NGXA_SHOP_ORDER")
public class Order extends BaseEntity {

	private String shopName;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="order_id", referencedColumnName="id")
	private List<OrderLine> lines = new ArrayList<>();

	private String orderNumber;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition="varchar")
	private OrderStatus status = OrderStatus.INCOMING;

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
