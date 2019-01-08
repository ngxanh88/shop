package de.ngxa.restaurant.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import de.ngxa.restaurant.dao.MenuDao;
import de.ngxa.restaurant.entity.Menu;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional(propagation = Propagation.SUPPORTS)
public class MenuDaoImpl extends BaseDaoImpl<Menu> implements MenuDao {

	@Override
	public List<Menu> findByShopName(String shopName) {
		final TypedQuery<Menu> query = super.em.createQuery("SELECT new Menu(m.id, m.name, m.description, m.shopName, m.parentMenu, m.urlName, m.index) " +
										   "FROM Menu m WHERE m.shopName =:shopName order by m.index asc", Menu.class);
		query.setParameter("shopName", shopName);

		return query.getResultList();
	}

	@Override
	public boolean deleteAll(String shopName) {
		final Query query = super.em.createQuery("Delete FROM Menu m WHERE m.shopName =:shopName");
		query.setParameter("shopName", shopName);
		return query.executeUpdate() != 0;
	}

}
