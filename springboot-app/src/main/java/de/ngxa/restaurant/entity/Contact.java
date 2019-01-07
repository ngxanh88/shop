package de.ngxa.restaurant.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
//@SequenceGenerator(name = "default_gen", sequenceName = "contact_seq", allocationSize = 1)
@Data
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
