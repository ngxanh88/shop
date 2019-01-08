package de.ngxa.restaurant.entity;

import de.ngxa.restaurant.constant.ShopType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="NGXA_SHOP")
public class Shop extends BaseEntity {

	private String owner;
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
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="shop_id", referencedColumnName="id")
	private List<ExtInfo> extInfo = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL)
	private MetaInfo metaInfo;

	@OneToOne(cascade = CascadeType.ALL)
	private Contact contact;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="shop_id", referencedColumnName="id")
	private List<OrderRegion> orderRegions = new ArrayList<>();

	@Column(nullable = false, columnDefinition = "boolean default true")
	private boolean isOrderAble = true;

	@Column(nullable = false, columnDefinition = "boolean default true")
	private boolean needIndex = true;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition="varchar")
	private ShopType shopType = ShopType.RESTAURANT;
	
	private String latitude;
	private String longitude;

}
