package groupwork.service;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class SessionCreator {
    public static final String MAIL_USER_PASSWORD = "mail.user.password";
    private static final String MAIL_USER_NAME = "mail.user.name";
    private String password;
    private String username;
    private Properties sessionProperties;

    public SessionCreator(Properties configProperties) {
        username = configProperties.getProperty(MAIL_USER_NAME);
        password = configProperties.getProperty(MAIL_USER_PASSWORD);

        this.sessionProperties = configProperties;
    }
    public Session createSession() {
        return Session.getDefaultInstance(sessionProperties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }
}
