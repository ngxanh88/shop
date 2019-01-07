package de.ngxa.restaurant.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "order_line_seq", allocationSize = 1)
public class OrderLine extends BaseEntity{	
	private static final long serialVersionUID = 1L;	
	
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
	
	public int getQuantity() {
		return quantity;
	}

	public String getExternalItemName() {
		return externalItemName;
	}
	
	public void setExternalItemName(String externalName) {
		this.externalItemName = externalName;
	}
	
	public String getExternalItemDesc() {
		return externalItemDesc;
	}
	
	public void setExternalItemDesc(String externalDesc) {
		this.externalItemDesc = externalDesc;
	}
	
	public double getExternalItemPrice() {
		return externalItemPrice;
	}
	
	public void setExternalItemPrice(double externalPrice) {
		this.externalItemPrice = externalPrice;
	}
	
	public String getExternalItemNumber() {
		return externalItemNumber;
	}
	
	public void setExternalItemNumber(String externalItemNumber) {
		this.externalItemNumber = externalItemNumber;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public List<OrderOption> getOptions() {
		return options;
	}

	public void setOptions(List<OrderOption> options) {
		this.options = options;
	}

	public boolean isInternal() {
		return isInternal;
	}

	public void setInternal(boolean isInternal) {
		this.isInternal = isInternal;
	}	
	
	

}
