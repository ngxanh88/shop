package de.ngxa.restaurant.dao.impl;

import de.ngxa.restaurant.dao.SpecialDao;
import de.ngxa.restaurant.entity.SpecialEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;


@Component
@Transactional(propagation = Propagation.SUPPORTS)
public class SpecialDaoImpl extends BaseDaoImpl<SpecialEntity> implements SpecialDao {

	@Override
	public List<SpecialEntity> getSpecials(int limiter, String city, Date date) {
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select s from SpecialEntity s  ");
		
		if(!StringUtils.isEmpty(city)) {
			stringBuilder.append("where lower(s.city) like lower(:city) ");
		}
		
		if(date != null) {
			if(stringBuilder.indexOf("where") > 0) {
				stringBuilder.append("and");
			} else {
				stringBuilder.append("where");
			}
			
			stringBuilder.append(" s.validFrom < :today and s.validTo > :today ");
		}
		stringBuilder.append(" order by s.createDate desc ");
		final TypedQuery<SpecialEntity> query = em.createQuery(stringBuilder.toString(), SpecialEntity.class);
		
		if(limiter > 0) {
			query.setMaxResults(limiter);
		}
		
		if(!StringUtils.isEmpty(city)) {
			query.setParameter("city","%" + city + "%");
		}
		
		if(date != null) {
			query.setParameter("today",date, TemporalType.DATE);
		}
		
		return query.getResultList();
	}

	@Override
	public List<SpecialEntity> getDefaultSpecials() {
		return getSpecials(3, null, null);
	}

	@Override
	public List<SpecialEntity> getAllSpecials() {
		final TypedQuery<SpecialEntity> query = em.createQuery("select s from SpecialEntity s order by s.createDate desc", SpecialEntity.class);
		return query.getResultList();
	}
}
