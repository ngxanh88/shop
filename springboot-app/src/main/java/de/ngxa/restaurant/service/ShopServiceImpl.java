package de.ngxa.restaurant.service;

import de.ngxa.restaurant.dao.RecommendDao;
import de.ngxa.restaurant.dao.ShopDao;
import de.ngxa.restaurant.dao.SpecialDao;
import de.ngxa.restaurant.entity.RecommendEntity;
import de.ngxa.restaurant.entity.Shop;
import de.ngxa.restaurant.entity.SpecialEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
@Transactional
public class ShopServiceImpl {

	private ShopDao shopDAO;

	private SpecialDao specialDao;

	private RecommendDao recommendDao;

	@Autowired
	public ShopServiceImpl(ShopDao shopDAO, SpecialDao specialDao, RecommendDao recommendDao) {
		this.shopDAO = shopDAO;
		this.specialDao = specialDao;
		this.recommendDao = recommendDao;
	}

	public Shop createOrUpdateShop(Shop shop) {
		if(shop.getId() != null) {
			return shopDAO.update(shop);
		}
		return shopDAO.create(shop);
	}

	public List<Shop> getShopByUser(String username) {
		return shopDAO.findByUser(username);
	}

	public Shop getShopByName(String shopName) {
		return shopDAO.findByName(shopName);
	}

	public boolean deleteShop(Long shopId) {
		return shopDAO.endDeleteById(shopId, Shop.class);
	}

	public List<SpecialEntity> getAllSpecial() {
		return specialDao.getAllSpecials();
	}

	public List<SpecialEntity> getSpecial(int limiter, String city) {
		final Date date = new Date();
		return specialDao.getSpecials(limiter, city, date);
	}

	public List<RecommendEntity> getRecommand(int limiter, String city) {
		return recommendDao.getRecommend(limiter, city);
	}

	public SpecialEntity createOrUpdateSpecial(SpecialEntity specialEntity) {
		if(specialEntity.getId() != null) {
			return specialDao.update(specialEntity);
		}
		return specialDao.create(specialEntity);
	}

	public boolean deleteSpecial(Long specialId) {
		return specialDao.endDeleteById(specialId, SpecialEntity.class);
	}

	public RecommendEntity createOrUpdateRecommend(RecommendEntity recommendEntity) {
		if(recommendEntity.getId() != null) {
			recommendDao.update(recommendEntity);
		}
		return recommendDao.create(recommendEntity);
	}

	public boolean deleteRecommend(Long recommendId) {
		return recommendDao.endDeleteById(recommendId, RecommendEntity.class);
	}

	public List<RecommendEntity> getAllRecommend() {
		return recommendDao.getAllRecommend();
	}

}
