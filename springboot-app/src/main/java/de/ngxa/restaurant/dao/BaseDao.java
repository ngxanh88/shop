package de.ngxa.restaurant.dao;

import de.ngxa.restaurant.exception.NotFoundException;

public interface BaseDao<T> {

	/**
	 * create entity
	 * @param entity new entity (id = null) to create
	 */
	T create(T entity);
	
	/**
	 * update entity
	 * @param entity existed entity (id != null) to update
	 */
	T update(T entity);
	
	/**
	 * delete entity 
	 * @param entity existed entity (id != null) to delete
	 */
	boolean endDelete(T entity);

	/**
	 *
	 * @param id id of entity
	 * @param clazz entity class
	 * @return true when delete success
	 */
	boolean endDeleteById(Long id, Class<T> clazz);
	
	/**
	 * search entity with id-param
	 * @param id id of entity
	 * @param clazz entity class
	 * @return T entity
	 * @throws NotFoundException when entity id is not existed
	 */
	T getByID(long id, Class<T> clazz) throws NotFoundException;

	/**
	 * search entity with id-param
	 * @param id id of entity
	 * @param clazz entity class
	 * @return T entity
	 */
	T findByID(long id, Class<T> clazz);
	
	/**
	 * try to delete a entity
	 * @param id id of entity
	 */
	boolean cancel(Long id, Class<T> clazz);
}
