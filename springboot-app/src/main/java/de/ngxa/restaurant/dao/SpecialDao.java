package de.ngxa.restaurant.dao;

import de.ngxa.restaurant.entity.SpecialEntity;

import java.util.Date;
import java.util.List;

public interface SpecialDao extends BaseDao<SpecialEntity>{
	
	List<SpecialEntity> getSpecials(int limiter, String city, Date date);
	
	List<SpecialEntity> getDefaultSpecials();
	
	List<SpecialEntity> getAllSpecials();
}
