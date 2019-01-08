package de.ngxa.restaurant.dao;

import de.ngxa.restaurant.entity.ShopUser;

import java.util.List;

public interface ShopUserDao {

	ShopUser getUser(String username, String password);

	List<ShopUser> getUsersShopName(String shopName);
}
