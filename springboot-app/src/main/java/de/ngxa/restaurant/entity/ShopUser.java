package de.ngxa.restaurant.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ESC_SHOP_USER")
//@SequenceGenerator(name = "default_gen", sequenceName = "user_seq", allocationSize = 1)
@Data
public class ShopUser extends BaseEntity{

	private String username;
	/**sha512 */
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private UserType userType;
	private Long shopId;	

}
