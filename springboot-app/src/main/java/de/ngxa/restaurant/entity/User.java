package de.ngxa.restaurant.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ESC_USER")
//@SequenceGenerator(name = "default_gen", sequenceName = "esc_user_seq", allocationSize = 1)
@Data
public class User extends BaseEntity {

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
