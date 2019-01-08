package de.ngxa.restaurant.dao.impl;

import de.ngxa.restaurant.dao.RecommendDao;
import de.ngxa.restaurant.entity.RecommendEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional(propagation = Propagation.SUPPORTS)
public class RecommendDaoImpl extends BaseDaoImpl<RecommendEntity> implements RecommendDao {

	@Override
	public List<RecommendEntity> getAllRecommend() {
		final TypedQuery<RecommendEntity> query = em.createQuery("select r from RecommendEntity r order by r.createDate desc", RecommendEntity.class);
		return query.getResultList();
	}

	@Override
	public List<RecommendEntity> getRecommend(int limiter, String city){
		final StringBuilder sql = new StringBuilder();
		sql.append("select r from RecommendEntity r ");
		
		if(!StringUtils.isEmpty(city)) {
			sql.append(" where lower(r.city) like lower(:city) ");
		}
		
		sql.append(" order by r.createDate desc");
		final TypedQuery<RecommendEntity> query = em.createQuery(sql.toString(), RecommendEntity.class);
		
		if(limiter > 0) {
			query.setMaxResults(limiter);
		}
		
		if(!StringUtils.isEmpty(city)) {
			query.setParameter("city","%" + city + "%");
		}

		return query.getResultList();
	}

	@Override
	public List<RecommendEntity> getDefaultRecommend() {
		return getRecommend(3, null);
	}
}
