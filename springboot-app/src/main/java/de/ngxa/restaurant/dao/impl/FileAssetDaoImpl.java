package de.ngxa.restaurant.dao.impl;

import de.ngxa.restaurant.dao.FileAssetDao;
import de.ngxa.restaurant.entity.FileAsset;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional(propagation= Propagation.SUPPORTS)
public class FileAssetDaoImpl extends BaseDaoImpl<FileAsset> implements FileAssetDao {

    @Override
    public List<FileAsset> getFileByCategoryId(Long categoryId) {
        final TypedQuery<FileAsset> query = em.createQuery("SELECT fa FROM FileAsset fa JOIN fa.category c " +
                "WHERE c.id=:categoryId ORDER BY fa.createDate DESC", FileAsset.class);
        query.setParameter("categoryId", categoryId);
        return query.getResultList();
    }

    @Override
    public List<FileAsset> getAllFileAsset() {
        final TypedQuery<FileAsset> query = em.createQuery("FROM FileAsset fa", FileAsset.class);
        return query.getResultList();
    }

    @Override
    public boolean endDeleteWithFlush(FileAsset fileAsset) {
        final boolean result = super.endDelete(fileAsset);
        super.em.flush();
        return result;
    }
}
