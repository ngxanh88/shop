package de.ngxa.restaurant.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="ESC_GROUP_OPTION")
@SequenceGenerator(name = "default_gen", sequenceName = "group_option_seq", allocationSize = 1)
public class GroupOption extends BaseEntity{

	private static final long serialVersionUID = 1L;

	private String name;
	private boolean isMultiChoice;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Option> options;
	
	private Long shopId;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "menuitem_group_option",
		joinColumns = { @JoinColumn(name = "GROUP_OPTION_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "MENU_ITEM_ID") })
	private List<MenuItem> menuItems;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public boolean isMultiChoice() {
		return isMultiChoice;
	}

	public void setMultiChoice(boolean isMultiChoice) {
		this.isMultiChoice = isMultiChoice;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}
}
