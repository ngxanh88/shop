package de.ngxa.restaurant.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
//@SequenceGenerator(name = "default_gen", sequenceName = "special_seq", allocationSize = 1)
@Data
public class SpecialEntity extends BaseEntity {

	private String title;
	@Column(columnDefinition = "TEXT")
	private String description;
	private String imageUrl;
	private Date validFrom;
	private Date validTo;
	private String city;

}
