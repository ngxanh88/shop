package de.ngxa.restaurant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="NGXA_SHOP_SPECIAL")
public class SpecialEntity extends BaseEntity {

	private String title;
	@Column(columnDefinition = "TEXT")
	private String description;
	private String imageUrl;
	private Date validFrom;
	private Date validTo;
	private String city;

}
