package de.ngxa.restaurant.service;

import de.ngxa.restaurant.constant.OrderStatus;
import de.ngxa.restaurant.dao.OrderDao;
import de.ngxa.restaurant.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
@Transactional
public class OrderService {

	private OrderDao orderDao;

	@Autowired
	public OrderService(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public Order sentOrder(Order order) {
		return orderDao.create(order);
	}

	public List<Order> getAllOrderByShopName(String shopName, Date date) {
		return orderDao.getOrderListByShopNameAndDate(shopName, date);
	}

	public Order updateStatus(OrderStatus orderStatus, Long orderId){
		final Order order = orderDao.getByID(orderId, Order.class);
		order.setStatus(orderStatus);
		return orderDao.update(order);
	}

	public Order getOrderByShopNameAndOrderId(String shopName, Long orderId) {
		return orderDao.getOrderByShopNameAndOrderId(shopName, orderId);
	}

}
