package de.ngxa.restaurant.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import de.ngxa.restaurant.dao.GroupOptionDao;
import de.ngxa.restaurant.entity.GroupOption;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional(propagation = Propagation.SUPPORTS)
public class GroupOptionDaoImpl extends BaseDaoImpl<GroupOption> implements GroupOptionDao {

	@Override
	public List<GroupOption> findByShopName(String shopName) {
		final TypedQuery<GroupOption> query = super.em.createQuery("FROM GroupOption gp WHERE gp.shopName =:shopName", GroupOption.class);
		query.setParameter("shopName", shopName);

		return query.getResultList();
	}

	@Override
	public GroupOption findByName(String groupOptionName) {
		final TypedQuery<GroupOption> query = super.em.createQuery("FROM GroupOption gp WHERE gp.name =:name", GroupOption.class);
		query.setParameter("name", groupOptionName);
		final List<GroupOption> results = query.getResultList();

		return results.isEmpty() ? null : results.get(0);
	}

	@Override
	public boolean deleteAll(String shopName) {
		final Query query = super.em.createQuery("Delete FROM GroupOption gp WHERE gp.shopName =:shopName");
		query.setParameter("shopName", shopName);
		return query.executeUpdate() != 0;
	}

}
