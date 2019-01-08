package de.ngxa.restaurant.entity;

import de.ngxa.restaurant.constant.UserType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="NGXA_SHOP_USER")
public class ShopUser extends BaseEntity {

	private String shopName;

	private String username;
	/**sha512 */
	private String password;
	private String firstName;
	private String lastName;
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition="varchar")
	private UserType userType = UserType.ADMIN;

}
