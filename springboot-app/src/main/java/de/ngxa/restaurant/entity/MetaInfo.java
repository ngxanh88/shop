package de.ngxa.restaurant.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
//@SequenceGenerator(name = "default_gen", sequenceName = "meta_info_seq", allocationSize = 1)
@Data
public class MetaInfo extends BaseEntity{

	private String logoURL;
	private String bannerURL;
	private String backgroundColor;

}
