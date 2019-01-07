package de.ngxa.restaurant.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "shop_seq", allocationSize = 1)
public class Shop extends BaseEntity {

	private static final long serialVersionUID = 4701936630270432821L;

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

	public String getLdapUserId() {
		return ldapUserId;
	}

	public void setLdapUserId(String ldapUserId) {
		this.ldapUserId = ldapUserId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public List<ExtInfo> getExtInfo() {
		return extInfo;
	}

	public void setExtInfo(List<ExtInfo> extInfo) {
		this.extInfo = extInfo;
	}

	public MetaInfo getMetaInfo() {
		return metaInfo;
	}

	public void setMetaInfo(MetaInfo metaInfo) {
		this.metaInfo = metaInfo;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<OrderRegion> getOrderRegions() {
		return orderRegions;
	}

	public void setOrderRegions(List<OrderRegion> orderRegions) {
		this.orderRegions = orderRegions;
	}

	public boolean isOrderAble() {
		return isOrderAble;
	}

	public void setOrderAble(boolean isOrderAble) {
		this.isOrderAble = isOrderAble;
	}

	public boolean isNeedIndex() {
		return needIndex;
	}

	public void setNeedIndex(boolean needIndex) {
		this.needIndex = needIndex;
	}

	public String getActualInfo() {
		return actualInfo;
	}

	public void setActualInfo(String actualInfo) {
		this.actualInfo = actualInfo;
	}

	public ShopType getShopType() {
		return shopType;
	}

	public void setShopType(ShopType shopType) {
		this.shopType = shopType;
	}

	public Long getMinOrderValue() {
		return minOrderValue;
	}

	public void setMinOrderValue(Long minOrderValue) {
		this.minOrderValue = minOrderValue;
	}

	public boolean isPartner() {
		return isPartner;
	}

	public void setPartner(boolean isPartner) {
		this.isPartner = isPartner;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}	
}
