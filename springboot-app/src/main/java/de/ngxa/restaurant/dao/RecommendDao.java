package de.ngxa.restaurant.dao;

import de.ngxa.restaurant.entity.RecommendEntity;

import java.util.List;

public interface RecommendDao extends BaseDao<RecommendEntity>{

	List<RecommendEntity> getAllRecommend();
	
	List<RecommendEntity> getDefaultRecommend();
	
	List<RecommendEntity> getRecommend(int limiter, String city);
}
