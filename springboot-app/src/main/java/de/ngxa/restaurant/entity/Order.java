package de.ngxa.restaurant.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ESC_ORDER")
@SequenceGenerator(name = "default_gen", sequenceName = "order_seq", allocationSize = 1)
public class Order extends BaseEntity{

	private static final long serialVersionUID = -1884534438208872879L;

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

	public List<OrderLine> getLines() {
		return lines;
	}

	public void setLines(List<OrderLine> lines) {
		this.lines = lines;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public boolean isPickup() {
		return isPickup;
	}

	public void setPickup(boolean isPickup) {
		this.isPickup = isPickup;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getContactCity() {
		return contactCity;
	}

	public void setContactCity(String contactCity) {
		this.contactCity = contactCity;
	}

	public String getContactPostalCode() {
		return contactPostalCode;
	}

	public void setContactPostalCode(String contactPostalCode) {
		this.contactPostalCode = contactPostalCode;
	}

	public String getContactStreet() {
		return contactStreet;
	}

	public void setContactStreet(String contactStreet) {
		this.contactStreet = contactStreet;
	}

	public String getContactStreetNr() {
		return contactStreetNr;
	}

	public void setContactStreetNr(String contactStreetNr) {
		this.contactStreetNr = contactStreetNr;
	}

	public double getRegionAdditionalPrice() {
		return regionAdditionalPrice;
	}

	public void setRegionAdditionalPrice(double regionAdditionalPrice) {
		this.regionAdditionalPrice = regionAdditionalPrice;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public boolean isInternal() {
		return isInternal;
	}

	public void setInternal(boolean isInternal) {
		this.isInternal = isInternal;
	}

	public String getTargetShopOwnerMail() {
		return targetShopOwnerMail;
	}

	public void setTargetShopOwnerMail(String targetShopOwnerMail) {
		this.targetShopOwnerMail = targetShopOwnerMail;
	}
	
	
}
