package de.ngxa.restaurant.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
//@SequenceGenerator(name = "default_gen", sequenceName = "recommend_seq", allocationSize = 1)
@Data
public class RecommendEntity extends BaseEntity {

	private String name;
	private String alias;
	private Long shopId;
	private String imgUrl;
	@Column(columnDefinition = "TEXT")
	private String description;
	private String address;
	private String city;

}
