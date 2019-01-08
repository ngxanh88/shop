package de.ngxa.restaurant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="NGXA_SHOP_META_INFO")
public class MetaInfo extends BaseEntity {

	private String logoURL;
	private String bannerURL;
	private String backgroundColor;

}
