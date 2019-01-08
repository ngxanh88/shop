package de.ngxa.restaurant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="NGXA_SHOP_CONTACT")
public class Contact extends BaseEntity {

	private String telephone;
	private String street;
	private String houseNr;
	private String district;
	private String city;
	private String postalCode;
	private String state;
	private String land;
	private String webURL;
	private String email;

}
