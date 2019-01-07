package de.ngxa.restaurant.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="ESC_GROUP_OPTION")
//@SequenceGenerator(name = "default_gen", sequenceName = "group_option_seq", allocationSize = 1)
@Data
public class GroupOption extends BaseEntity {

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

}
