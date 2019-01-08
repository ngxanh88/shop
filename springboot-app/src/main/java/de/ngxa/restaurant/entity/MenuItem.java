package de.ngxa.restaurant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(
		uniqueConstraints= @UniqueConstraint(columnNames = {"number", "shopName"}),
		name="NGXA_MENU_ITEM"
)
public class MenuItem extends BaseEntity {

	@Column(name="shopName")
	private String shopName;

	@Column(name="number")
	private String number;
	private String name;
	@Column(columnDefinition = "TEXT")
	private String longDecs;
	private String shortDecs;
	private String mainImgURL;
	private float grossBasePrice;
	private long orderCounter = 0;

	@ManyToOne
	@JoinColumn(name = "menu_id", referencedColumnName="id", insertable = false, updatable = false)
	private Menu menu;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "NGXA_MENU_MENUITEM_GROUP_OPTION",
		joinColumns = { @JoinColumn(name = "menu_item_id") },
		inverseJoinColumns = { @JoinColumn(name = "group_option_id") })
	private List<GroupOption> groupOptions = new ArrayList<>();

}
