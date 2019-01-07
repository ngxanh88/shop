package de.ngxa.restaurant.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
//@SequenceGenerator(name = "default_gen", sequenceName = "menu_seq", allocationSize = 1)
@Data
public class Menu extends BaseEntity {

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

	public Menu(){
	}

	public Menu(Long id, String name, String description, Long shopId, String parentMenu, String urlName, int index) {
		setId(id);
		setName(name);
		setDescription(description);
		setShopId(shopId);
		setParentMenu(parentMenu);
		setUrlName(urlName);
		setIndex(index);
	}

}
