package de.ngxa.restaurant.dao;

import de.ngxa.restaurant.entity.EmailConfigEntity;

import java.util.List;

public interface EmailConfigDao extends BaseDao<EmailConfigEntity>{

	EmailConfigEntity findByServiceName(String serviceName);
	
	List<EmailConfigEntity> getAllSystemMailConfig();
}
