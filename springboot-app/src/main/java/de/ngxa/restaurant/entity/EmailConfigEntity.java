package de.ngxa.restaurant.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name="NGXA_SYS_EMAIL_CONFIG")
public class EmailConfigEntity extends BaseEntity {

	private String username;
	private String password;
	
	private String emailAddress;

	private String serviceName;
	/** "true" or "false" **/
	private String smtpAuth = "true";
	private String transportProtocol;
	private String socketFactoryPort;
	private String smtpHost;
	private String smtpPort;
	/** true or false **/
	private String startTlsEnable = "true";

}
