package de.ngxa.restaurant.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints=
@UniqueConstraint(columnNames = {"number", "shopId"}))
@SequenceGenerator(name = "default_gen", sequenceName = "menu_item_seq", allocationSize = 1)
public class MenuItem extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name="number")
	private String number;
	private String name;
	@Column(columnDefinition = "TEXT")
	private String longDecs;
	private String shortDecs;
	private String mainImgURL;
	private float grossBasePrice;
	private long orderCounter = 0;
	private Long menuId;
	@Column(name="shopId")
	private Long shopId;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="MENU_MENU_ITEM",
	   joinColumns={@JoinColumn(name="MENU_ITEM_ID")},
	   inverseJoinColumns={@JoinColumn(name="MENU_ID")})
	private List<Menu> menus = new ArrayList<Menu>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "menuitem_group_option", 
		joinColumns = { @JoinColumn(name = "MENU_ITEM_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "GROUP_OPTION_ID") })
	private List<GroupOption> groupOptions;
	
	

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getLongDecs() {
		return longDecs;
	}

	public void setLongDecs(String longDecs) {
		this.longDecs = longDecs;
	}

	public String getShortDecs() {
		return shortDecs;
	}

	public void setShortDecs(String shortDecs) {
		this.shortDecs = shortDecs;
	}

	public String getMainImgURL() {
		return mainImgURL;
	}

	public void setMainImgURL(String mainImgURL) {
		this.mainImgURL = mainImgURL;
	}

	public float getGrossBasePrice() {
		return grossBasePrice;
	}

	public void setGrossBasePrice(float grossBasePrice) {
		this.grossBasePrice = grossBasePrice;
	}
	
	public void incrementOrderCounter(){
		orderCounter++;
	}
	
	public void decrementOrderCounter(){
		orderCounter--;
	}
	
	public void resetOrderCounter(){
		setOrderCounter(0L);
	}

	public long getOrderCounter() {
		return orderCounter;
	}

	public void setOrderCounter(long orderCounter) {
		this.orderCounter = orderCounter;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<GroupOption> getGroupOptions() {
		return groupOptions;
	}

	public void setGroupOptions(List<GroupOption> groupOptions) {
		this.groupOptions = groupOptions;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}	
	
	
}
