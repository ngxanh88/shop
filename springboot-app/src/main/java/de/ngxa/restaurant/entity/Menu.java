package de.ngxa.restaurant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="NGXA_MENU")
public class Menu extends BaseEntity {

	private String shopName;
	private String parentMenu;

	private String name;
	private String description;
	private String urlName;
	private int index = 1;

	@OneToMany(mappedBy="menu", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<MenuItem> items = new ArrayList<>();

	public Menu(){
	}

	public Menu(Long id, String name, String description, String shopName, String parentMenu, String urlName, int index) {
		setId(id);
		setName(name);
		setDescription(description);
		setShopName(shopName);
		setParentMenu(parentMenu);
		setUrlName(urlName);
		setIndex(index);
	}

}
