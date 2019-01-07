package de.ngxa.restaurant.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
//@SequenceGenerator(name = "default_gen", sequenceName = "image_file_seq", allocationSize = 1)
@Data
public class ImageFile extends BaseEntity {

	private String name;
	private String rawName;
	private String owner;
	private String description;

}
