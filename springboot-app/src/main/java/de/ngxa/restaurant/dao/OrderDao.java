package de.ngxa.restaurant.dao;

import de.ngxa.restaurant.constant.OrderStatus;
import de.ngxa.restaurant.entity.Order;

import java.util.Date;
import java.util.List;

public interface OrderDao extends BaseDao<Order>{
	
	Order findByShopNameAndOrderNumber(String shopName, String orderNumber);
	
	List<Order> getOrderListByShopNameAndDate(String shopName, Date date);
	
	Order getOrderByShopNameAndOrderId(String shopName, Long orderId);
	
	List<Order> getOrderByInterval(String shopName, Date from, Date to);
}
