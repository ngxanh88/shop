package de.ngxa.restaurant.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
//@SequenceGenerator(name = "default_gen", sequenceName = "shop_seq", allocationSize = 1)
@Data
public class Shop extends BaseEntity {

	private String ldapUserId;
	private String name;
	private String alias;
	@Column(columnDefinition = "TEXT")
	private String longDesc;
	private String shortDesc;
	@Column(columnDefinition = "TEXT")
	private String openingTime;
	private String privacy;
	private String actualInfo;
	private Long minOrderValue = 0L;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<ExtInfo> extInfo;
	@OneToOne(cascade = CascadeType.ALL)
	private MetaInfo metaInfo;
	@OneToOne(cascade = CascadeType.ALL)
	private Contact contact;
	@OneToMany(targetEntity = OrderRegion.class, fetch = FetchType.EAGER)
	private List<OrderRegion> orderRegions;

	@Column(nullable = false, columnDefinition = "boolean default false")
	private boolean isOrderAble = false;

	@Column(nullable = false, columnDefinition = "boolean default true")
	private boolean needIndex = true;
	
	@Column(nullable = false, columnDefinition = "boolean default false")
	private boolean isPartner =  false;

	private ShopType shopType = ShopType.RESTAURANT;
	
	private String latitude;
	private String longitude;

}
