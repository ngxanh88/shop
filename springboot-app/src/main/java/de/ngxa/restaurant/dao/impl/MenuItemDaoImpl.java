package de.ngxa.restaurant.dao.impl;

import de.ngxa.restaurant.dao.MenuItemDao;
import de.ngxa.restaurant.entity.MenuItem;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional(propagation = Propagation.SUPPORTS)
public class MenuItemDaoImpl extends BaseDaoImpl<MenuItem> implements MenuItemDao {

	private static final int FIRST_ITEM = 0;
	private static final String FROM_ITEM_WHERE = "FROM MenuItem m where";

	@Override
	public MenuItem findByItemNumber(String shopName, String number) {
		final TypedQuery<MenuItem> query = em.createQuery(FROM_ITEM_WHERE + " m.shopName = :shopName and m.number = :number", MenuItem.class);
		query.setParameter("shopName", shopName);
		query.setParameter("number", number);
		final List<MenuItem> articles = query.getResultList();

		return articles.isEmpty() ? null: articles.get(FIRST_ITEM);
	}

	@Override
	public List<MenuItem> findByShopNameAndMenuId(String shopName, Long menuId) {
		final TypedQuery<MenuItem> query = em.createQuery(FROM_ITEM_WHERE + " m.shopName = :shopName and m.menu.id = :menuId order by m.createDate desc", MenuItem.class);
		query.setParameter("shopName", shopName);
		query.setParameter("menuId", menuId);

		return query.getResultList();
	}

	@Override
	public List<MenuItem> findByName(String name) {
		final TypedQuery<MenuItem> query = em.createQuery(FROM_ITEM_WHERE + " m.name = :name order by m.createDate desc", MenuItem.class);
		query.setParameter("name", name);

		return query.getResultList();
	}

	@Override
	public boolean deleteByMenuId(String shopName, Long menuId) {
		final Query deleteQuery = em.createQuery("delete from MenuItem mi where " +
															"mi.menu.id = :menuId and " +
															"mi.shopName=:shopName");
		deleteQuery.setParameter("menuId", menuId);
		deleteQuery.setParameter("shopName", shopName);

		return deleteQuery.executeUpdate() > 0;
	}
	
	@Override
	public boolean deleteAll(String shopName) {
		final Query query = super.em.createQuery("Delete FROM MenuItem mi WHERE mi.shopName =:shopName");
		query.setParameter("shopName", shopName);

		return query.executeUpdate() > 0;
	}

}
