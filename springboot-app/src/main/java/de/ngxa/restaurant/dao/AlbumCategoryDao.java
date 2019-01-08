package de.ngxa.restaurant.dao;

import de.ngxa.restaurant.entity.AlbumCategory;

import java.util.List;

public interface AlbumCategoryDao extends BaseDao<AlbumCategory>{

    List<AlbumCategory> getAllCategory();
}
