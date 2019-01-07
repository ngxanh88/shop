package de.ngxa.restaurant.entity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="FTP_CONFIG")
@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "ftp_config_seq", allocationSize = 1)
public class FtpConfigEntity extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	private String host;
	private String port;
	private String username;
	private String password;
	private boolean isActive;
	private String partnerName;
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}	
}
