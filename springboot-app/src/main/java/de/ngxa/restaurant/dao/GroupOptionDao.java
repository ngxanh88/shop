package de.ngxa.restaurant.dao;

import de.ngxa.restaurant.entity.GroupOption;

import java.util.List;

public interface GroupOptionDao extends BaseDao<GroupOption>{

	List<GroupOption> findByShopName(String shopName);
	
	GroupOption findByName(String groupOptionName);

	boolean deleteAll(String shopName);
}
