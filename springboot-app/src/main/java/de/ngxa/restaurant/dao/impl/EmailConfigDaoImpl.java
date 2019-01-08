package de.ngxa.restaurant.dao.impl;

import de.ngxa.restaurant.dao.EmailConfigDao;
import de.ngxa.restaurant.entity.EmailConfigEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional(propagation = Propagation.SUPPORTS)
public class EmailConfigDaoImpl extends BaseDaoImpl<EmailConfigEntity> implements EmailConfigDao {

	@Override
	public EmailConfigEntity findByServiceName(String serviceName) {
		final TypedQuery<EmailConfigEntity> query = super.em.createQuery("SELECT ece FROM EmailConfigEntity ece where ece.serviceName=:serviceName", EmailConfigEntity.class);
		query.setParameter("serviceName", serviceName);
		final List<EmailConfigEntity> resultList = query.getResultList();
		return resultList.isEmpty() ? null : resultList.get(0);
	}

	@Override
	public List<EmailConfigEntity> getAllSystemMailConfig() {
		final TypedQuery<EmailConfigEntity> query = super.em.createQuery("SELECT ece FROM EmailConfigEntity ece ORDER BY ece.createDate DESC", EmailConfigEntity.class);
		return query.getResultList();
	}

}
