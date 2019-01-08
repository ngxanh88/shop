package de.ngxa.restaurant.dto;

import de.ngxa.restaurant.entity.AlbumCategory;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class FileAssetDto extends BaseDto {

	@NotNull
	private AlbumCategory category;

	@NotEmpty
	private String fileName;
	private long fileSize;
	private String fileUrl;
	private String rawName;
	private String extension;
	private String fileType;
	@NotEmpty
	private byte[] content;

	private String hashFileName;
}
