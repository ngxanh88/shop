package de.ngxa.restaurant.entity;

import lombok.Data;

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
@UniqueConstraint(columnNames = {"number", "shopName"}))
//@SequenceGenerator(name = "default_gen", sequenceName = "menu_item_seq", allocationSize = 1)
@Data
public class MenuItem extends BaseEntity {

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
	@Column(name="shopName")
	private String shopName;
	
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

}
