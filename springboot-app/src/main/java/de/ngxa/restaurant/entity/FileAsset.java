package de.ngxa.restaurant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="NGXA_SYS_FILE_ASSET")
public class FileAsset extends BaseEntity {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", referencedColumnName="id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private AlbumCategory category;

	private String rawName;
	private String hashFileName;
	private String extension;
	private String fileType;
	private long fileSize;
	private String fileUrl;

}
