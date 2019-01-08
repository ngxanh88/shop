package de.ngxa.restaurant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="NGXA_SHOP_RECOMMEND")
public class RecommendEntity extends BaseEntity {

	private String shopName;

	private String name;
	private String alias;
	private String imgUrl;
	@Column(columnDefinition = "TEXT")
	private String description;
	private String address;
	private String city;

}
