package de.ngxa.restaurant.dao.impl;

import de.ngxa.restaurant.dao.AlbumCategoryDao;
import de.ngxa.restaurant.entity.AlbumCategory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional(propagation= Propagation.SUPPORTS)
public class AlbumCategoryDaoImpl extends BaseDaoImpl<AlbumCategory> implements AlbumCategoryDao {

    @Override
    public List<AlbumCategory> getAllCategory() {
        final TypedQuery<AlbumCategory> query = em.createQuery("FROM AlbumCategory ab", AlbumCategory.class);
        return query.getResultList();
    }
}
