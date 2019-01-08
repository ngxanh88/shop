package de.ngxa.restaurant.dao;

import de.ngxa.restaurant.entity.Shop;

import java.util.List;

public interface ShopDao extends BaseDao<Shop>{

	List<Shop> findByUser(String owner);

	Shop findByName(String name);

	List<Shop> getShopsForIndexing();
	
	List<Shop> getShopsFromCity(String city);
}
