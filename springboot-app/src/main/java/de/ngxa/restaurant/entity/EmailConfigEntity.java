package de.ngxa.restaurant.entity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="EMAIL_CONFIG")
@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "email_config_seq", allocationSize = 1)
public class EmailConfigEntity extends BaseEntity {
	private static final long serialVersionUID = -7912815443447761023L;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getSmtpAuth() {
		return smtpAuth;
	}

	public void setSmtpAuth(String smtpAuth) {
		this.smtpAuth = smtpAuth;
	}

	public String getTransportProtocol() {
		return transportProtocol;
	}

	public void setTransportProtocol(String transportProtocol) {
		this.transportProtocol = transportProtocol;
	}

	public String getSocketFactoryPort() {
		return socketFactoryPort;
	}

	public void setSocketFactoryPort(String socketFactoryPort) {
		this.socketFactoryPort = socketFactoryPort;
	}

	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public String getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(String smtpPort) {
		this.smtpPort = smtpPort;
	}

	public String getStartTlsEnable() {
		return startTlsEnable;
	}

	public void setStartTlsEnable(String startTlsEnable) {
		this.startTlsEnable = startTlsEnable;
	}

}
