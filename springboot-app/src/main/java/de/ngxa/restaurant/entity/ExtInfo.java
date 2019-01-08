package de.ngxa.restaurant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="NGXA_SHOP_EXT_INFO")
public class ExtInfo extends BaseEntity {

	private String extKey;
	private String extValue;

}
