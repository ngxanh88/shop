package de.ngxa.restaurant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="NGXA_MENU_GROUP_OPTION")
public class GroupOption extends BaseEntity {

	private String shopName;

	private String name;
	private boolean isMultiChoice;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="group_option_id", referencedColumnName="id")
	private List<Option> options = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "NGXA_MENU_MENUITEM_GROUP_OPTION",
		joinColumns = { @JoinColumn(name = "group_option_id") },
		inverseJoinColumns = { @JoinColumn(name = "menu_item_id") })
	private List<MenuItem> menuItems = new ArrayList<>();

}
