package de.ngxa.restaurant.dao;

import de.ngxa.restaurant.entity.Menu;

import java.util.List;

public interface MenuDao extends BaseDao<Menu> {

	List<Menu> findByShopName(String shopName);

	boolean deleteAll(String shopName);
	
	
}
