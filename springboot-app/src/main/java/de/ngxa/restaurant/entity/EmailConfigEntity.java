package de.ngxa.restaurant.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="EMAIL_CONFIG")
@Entity
//@SequenceGenerator(name = "default_gen", sequenceName = "email_config_seq", allocationSize = 1)
@Data
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
