package de.ngxa.restaurant.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "menu_seq", allocationSize = 1)
public class Menu extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private String urlName;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)	
	@JoinTable(name="MENU_MENU_ITEM",
			   joinColumns={@JoinColumn(name="MENU_ID")},
			   inverseJoinColumns={@JoinColumn(name="MENU_ITEM_ID")})
	private List<MenuItem> items;
	
	private Long shopId;
	
	private String parentMenu;
	
	private int index = 1;
	
	/**
	 * dfault constructor
	 */
	public Menu(){
		
	}
	
	/**
	 * constructor for read only attributes
	 * @param id
	 * @param name
	 * @param desc
	 * @param shopId
	 */
	public Menu(Long id, String name, String description, Long shopId, String parentMenu, String urlName, int index){
		setId(id);
		setName(name);
		setDescription(description);
		setShopId(shopId);
		setParentMenu(parentMenu);
		setUrlName(urlName);
		setIndex(index);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<MenuItem> getItems() {
		return items;
	}

	public void setItems(List<MenuItem> items) {
		this.items = items;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(String parentMenu) {
		this.parentMenu = parentMenu;
	}

	public String getUrlName() {
		return urlName;
	}

	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	

}
