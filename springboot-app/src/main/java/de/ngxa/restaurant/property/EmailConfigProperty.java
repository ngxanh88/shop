package de.ngxa.restaurant.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class EmailConfigProperty {

    @Value("${tpz.mail.smtp.host:http://localhost}")
    private String smtpHost;
    @Value("${tpz.mail.smtp.port:25}")
    private String smtpPort;
    @Value("${tpz.mail.smtp.auth:true}")
    private String smtpAuth;

    @Value("${tpz.mail.smtp.starttls.enable:true}")
    private String startTlsEnable = "true";
    @Value("${tpz.mail.transport.protocol:smtp}")
    private String transportProtocol;
    @Value("${tpz.mail.socket.factory.port:25}")
    private String socketFactoryPort;

    @Value("${tpz.mail.address:localhost}")
    private String emailAddress;

    @Value("${tpz.mail.user.username:admin@localhost}")
    private String username;
    @Value("${tpz.mail.user.password:123456}")
    private String password;

    @Value("${tpz.mail.user.email.alias:admin@localhost}")
    private String aliasEmail;
    @Value("${tpz.mail.user.email.targets:info@localhost|support@localhost}")
    private String targetEmails;

}
