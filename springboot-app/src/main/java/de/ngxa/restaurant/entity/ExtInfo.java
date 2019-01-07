package de.ngxa.restaurant.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
//@SequenceGenerator(name = "default_gen", sequenceName = "ext_info_seq", allocationSize = 1)
@Data
public class ExtInfo extends BaseEntity {

	private String extKey;
	private String extValue;

}
