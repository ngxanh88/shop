package de.ngxa.restaurant.entity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "ext_info_seq", allocationSize = 1)
public class ExtInfo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String extKey;
	private String extValue;

	public String getExtKey() {
		return extKey;
	}

	public void setExtKey(String extKey) {
		this.extKey = extKey;
	}

	public String getExtValue() {
		return extValue;
	}

	public void setExtValue(String extValue) {
		this.extValue = extValue;
	}

}
