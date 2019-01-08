package de.ngxa.restaurant.dao.impl;

import de.ngxa.restaurant.dao.ShopUserDao;
import de.ngxa.restaurant.entity.ShopUser;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional(propagation = Propagation.SUPPORTS)
public class ShopUserDaoImpl extends BaseDaoImpl<ShopUser> implements ShopUserDao {

	@Override
	public ShopUser getUser(String username, String password) {
		final TypedQuery<ShopUser> query = super.em.createQuery("select u from ShopUser u where u.username = :username and u.password = :password", ShopUser.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		final List<ShopUser> users = query.getResultList();

		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public List<ShopUser> getUsersShopName(String shopName){
		final TypedQuery<ShopUser> query = super.em.createQuery("select u from ShopUser u where u.shopName = :shopName", ShopUser.class);
		query.setParameter("shopName", shopName);
		return query.getResultList();		
	}
}
