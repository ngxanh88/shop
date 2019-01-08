package de.ngxa.restaurant.service;

import de.ngxa.restaurant.dao.EmailConfigDao;
import de.ngxa.restaurant.entity.EmailConfigEntity;
import de.ngxa.restaurant.property.EmailConfigProperty;
import de.ngxa.restaurant.utils.ConverterModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class SystemConfigParamService {

	private EmailConfigDao emailConfigDao;

	private EmailConfigProperty emailConfigProperty;

	@Autowired
	public SystemConfigParamService(EmailConfigDao emailConfigDao, EmailConfigProperty emailConfigProperty) {
		this.emailConfigDao = emailConfigDao;
		this.emailConfigProperty = emailConfigProperty;
	}

	public EmailConfigEntity getSystemMailConfig(String serviceName) {
		final EmailConfigEntity existingEntity = emailConfigDao.findByServiceName(serviceName);

		if(existingEntity == null) {
			return ConverterModelMapper.map(emailConfigProperty, EmailConfigEntity.class);
		}
		return existingEntity;
	}

	public List<EmailConfigEntity> getAllSystemMailConfig() {
		return emailConfigDao.getAllSystemMailConfig();
	}

	public EmailConfigEntity createMailConfig(EmailConfigEntity entity) {
		return emailConfigDao.create(entity);
	}

	public EmailConfigEntity updateMailConfig(EmailConfigEntity entity) {
		return emailConfigDao.update(entity);
	}

	public boolean deleteMailConfig(Long emailConfigId) {
		return emailConfigDao.endDeleteById(emailConfigId, EmailConfigEntity.class);
	}

}
