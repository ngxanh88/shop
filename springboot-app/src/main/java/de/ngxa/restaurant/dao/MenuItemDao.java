package de.ngxa.restaurant.dao;

import de.ngxa.restaurant.entity.MenuItem;

import java.util.List;

public interface MenuItemDao extends BaseDao<MenuItem>{

	MenuItem findByItemNumber(String shopName, String number);

	List<MenuItem> findByShopNameAndMenuId(String shopName, Long menuId);
	
	List<MenuItem> findByName(String name);
	
	boolean deleteByMenuId(String shopName, Long menuId);

	boolean deleteAll(String shopName);
	
}
