package de.ngxa.restaurant.dao.impl;

import de.ngxa.restaurant.dao.ShopDao;
import de.ngxa.restaurant.entity.Shop;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional(propagation = Propagation.SUPPORTS)
public class ShopDaoImpl extends BaseDaoImpl<Shop> implements ShopDao {

	private static final int FIRST_ITEM = 0;

	@Override
	public List<Shop> findByUser(String owner) {
		final TypedQuery<Shop> query = em.createQuery("select s from Shop s where lower(s.owner) = lower(:owner)", Shop.class);
		query.setParameter("owner", owner);
		return query.getResultList();
	}

	@Override
	public Shop findByName(String name) {
		final TypedQuery<Shop> query = em.createQuery("select s from Shop s where lower(s.name) = :name", Shop.class);
		query.setParameter("name", name.toLowerCase());
		final List<Shop> foundShopList = query.getResultList();

		return foundShopList.isEmpty() ? null : foundShopList.get(FIRST_ITEM);
	}

	@Override
	public List<Shop> getShopsForIndexing() {
		final TypedQuery<Shop> query = em.createQuery("select s from Shop s where s.needIndex = :needIndex", Shop.class);
		query.setParameter("needIndex", true);
		return query.getResultList();
	}

	@Override
	public List<Shop> getShopsFromCity(String city) {
		final TypedQuery<Shop> query = em.createQuery("select s from Shop s where lower(s.contact.city) like lower(:city)", Shop.class);
		query.setParameter("city", "%" + city + "%");
		return query.getResultList();
	}

}
