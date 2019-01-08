package de.ngxa.restaurant.service;

import de.ngxa.restaurant.dao.FileAssetDao;
import de.ngxa.restaurant.dto.FileAssetDto;
import de.ngxa.restaurant.entity.FileAsset;
import de.ngxa.restaurant.exception.BadRequestException;
import de.ngxa.restaurant.property.SystemProperty;
import de.ngxa.restaurant.utils.AppUtil;
import de.ngxa.restaurant.utils.ConverterModelMapper;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;

import static de.ngxa.restaurant.constant.SystemConstant.FILE_SEPARATOR;
import static de.ngxa.restaurant.constant.SystemConstant.FILE_UPLOAD_FOLDER_NAME;


@Component
@Transactional
public class FileAssetService {

    private FileAssetDao fileAssetDao;

    private SystemProperty systemProperty;

    @Autowired
    public FileAssetService(SystemProperty systemProperty, FileAssetDao fileAssetDao) {
        this.systemProperty = systemProperty;
        this.fileAssetDao = fileAssetDao;
    }

    public FileAsset uploadFile(FileAssetDto dto) throws IOException {
        if(dto.getContent() == null || dto.getContent().length == 0) {
            throw new BadRequestException("can not upload file with none content.");
        }

        dto.setHashFileName(AppUtil.getSHA512(dto.getRawName() + (new Date()).getTime()));

        final String fileRelPath = buildRelativePathOfUploadFileResource(dto.getHashFileName() + "." + dto.getExtension());
        FileUtils.writeByteArrayToFile(new File(systemProperty.getResourcesPath() + FILE_SEPARATOR + fileRelPath), dto.getContent());

        dto.setFileUrl(systemProperty.getHost() + FILE_SEPARATOR + fileRelPath);

        return fileAssetDao.create(ConverterModelMapper.map(dto, FileAsset.class));
    }

    public boolean deleteFile(Long fileId) throws IOException {
        final FileAsset existingFile = fileAssetDao.findByID(fileId, FileAsset.class);

        if (existingFile == null) {
            return false;
        }

        final String fileRelPath = buildRelativePathOfUploadFileResource( existingFile.getHashFileName() + "." + existingFile.getExtension());
        if(fileAssetDao.endDeleteWithFlush(existingFile)) {
            final File file = new File(systemProperty.getResourcesPath() + FILE_SEPARATOR + fileRelPath);
            Files.delete(file.toPath());

            return true;
        }

        return false;

    }

    public List<FileAsset> getFileByCategoryId(Long categoryId) {
        return fileAssetDao.getFileByCategoryId(categoryId);
    }

    public List<FileAsset> getAllFileAsset() {
        return fileAssetDao.getAllFileAsset();
    }

    private String buildRelativePathOfUploadFileResource(String fileNameWithExtension) {
        return FILE_UPLOAD_FOLDER_NAME + FILE_SEPARATOR + fileNameWithExtension;
    }
}
