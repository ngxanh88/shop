package de.ngxa.restaurant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="NGXA_SHOP_CUSTOMER_USER")
public class CustomerUser extends BaseEntity {

	private String username;
	/**sha512 */
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	
	private String telephone;
	private String street;
	private String houseNr;
	private String city;
	private String postalCode;

}
