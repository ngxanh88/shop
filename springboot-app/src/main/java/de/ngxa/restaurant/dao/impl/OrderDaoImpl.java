package de.ngxa.restaurant.dao.impl;

import de.ngxa.restaurant.dao.OrderDao;
import de.ngxa.restaurant.entity.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;


@Component
@Transactional(propagation = Propagation.SUPPORTS)
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao {

	@Override
	public Order findByShopNameAndOrderNumber(String shopName, String orderNumber) {
		final TypedQuery<Order> findOrderByShopIdAndOrderNumber = super.em.createQuery("SELECT o FROM Order o WHERE o.shopName =:shopName and o.orderNumber =:orderNumber", Order.class);
		findOrderByShopIdAndOrderNumber.setParameter("shopName", shopName);
		findOrderByShopIdAndOrderNumber.setParameter("orderNumber", orderNumber);
		final List<Order> result =  findOrderByShopIdAndOrderNumber.getResultList();

		return result.isEmpty() ? null : result.get(0);
	}

	@Override
	public List<Order> getOrderListByShopNameAndDate(String shopName, Date date) {
		final TypedQuery<Order> findOrderByShopId = super.em.createQuery("SELECT o FROM Order o WHERE o.shopName =:shopName and date(o.createDate) = :date order by o.createDate desc", Order.class);
		findOrderByShopId.setParameter("shopName", shopName);
		findOrderByShopId.setParameter("date", date, TemporalType.DATE);

		return findOrderByShopId.getResultList();
	}

	@Override
	public Order getOrderByShopNameAndOrderId(String shopName, Long orderId) {
		final TypedQuery<Order> findOrderByShopIdAndOrderNumber = super.em.createQuery("SELECT o FROM Order o WHERE o.shopName =:shopName and o.id =:id", Order.class);
		findOrderByShopIdAndOrderNumber.setParameter("shopName", shopName);
		findOrderByShopIdAndOrderNumber.setParameter("id", orderId);
		final List<Order> result =  findOrderByShopIdAndOrderNumber.getResultList();

		return result.isEmpty() ? null : result.get(0);
	}

	@Override
	public List<Order> getOrderByInterval(String shopName, Date from, Date to) {
		final TypedQuery<Order> getAllOrderByTimeInterval = super.em.createQuery("SELECT o FROM Order o WHERE o.shopName=:shopName and o.createDate >= :from and o.createDate <=:to order by o.createDate desc", Order.class);
		getAllOrderByTimeInterval.setParameter("from", from);
		getAllOrderByTimeInterval.setParameter("to", to);
		getAllOrderByTimeInterval.setParameter("shopName", shopName);

		return getAllOrderByTimeInterval.getResultList();
		
	}

	
}
