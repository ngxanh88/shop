package de.ngxa.restaurant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="NGXA_SYS_FILE_ALBUM_CATEGORY")
public class AlbumCategory extends BaseEntity {

    private String owner;

    @NotEmpty
    private String categoryName;

    @Column(columnDefinition="text")
    private String description;
}
