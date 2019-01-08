package de.ngxa.restaurant.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class SystemProperty {

	@Value("${application.server.host:http://localhost}")
	private String host;
	@Value("${application.server.resource.path:/resources}")
	private String resourcesPath;

	@Value("${main.rest.public.key:shop-public-key}")
	private String restPublicKey;
	@Value("${main.rest.private.key:123456}")
	private String restPrivateKey;

}
