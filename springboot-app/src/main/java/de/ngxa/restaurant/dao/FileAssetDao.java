package de.ngxa.restaurant.dao;

import de.ngxa.restaurant.entity.FileAsset;

import java.util.List;

public interface FileAssetDao extends BaseDao<FileAsset> {

    List<FileAsset> getFileByCategoryId(Long categoryId);

    List<FileAsset> getAllFileAsset();

    boolean endDeleteWithFlush(FileAsset fileAsset);
}
