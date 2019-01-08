package de.ngxa.restaurant.dao.impl;

import de.ngxa.restaurant.dao.BaseDao;
import de.ngxa.restaurant.entity.BaseEntity;
import de.ngxa.restaurant.exception.NotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

public class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {

	@PersistenceContext
	protected EntityManager em;

	@Transactional(propagation= Propagation.REQUIRED)
	@Override
	public T create(T entity) {
		entity.setModifiedDate(new Date());
		em.persist(entity);
		return entity;
	}

	@Transactional(propagation= Propagation.REQUIRED)
	@Override
	public T update(T entity) {
		entity.setModifiedDate(new Date());
		return em.merge(entity);
	}

	@Transactional(propagation= Propagation.REQUIRED)
	@Override
	public boolean endDelete(T entity) {
		em.remove(entity);
		return true;
	}

	@Transactional(propagation= Propagation.REQUIRED)
	@Override
	public boolean endDeleteById(Long id, Class<T> clazz) {
		final T existingEntity = findByID(id, clazz);
		return existingEntity != null && endDelete(existingEntity);
	}

	@Override
	public T getByID(long id, Class<T> clazz) throws NotFoundException {
		final T existingEntity = em.find(clazz, id);
		if(existingEntity == null) {
			throw new NotFoundException("Entity " + clazz.getSimpleName() + " with id " + id + " is not existed.");
		}
		return existingEntity;
	}

	@Override
	public T findByID(long id, Class<T> clazz) {
		return em.find(clazz, id);
	}

	@Transactional(propagation= Propagation.REQUIRED)
	@Override
	public boolean cancel(Long id, Class<T> clazz) {
		final T entity = getByID(id, clazz);
		entity.setDeleted(true);
		update(entity);
		return true;
	}
}
