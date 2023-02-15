package groupwork.service.fabrics;

import groupwork.service.MailService;

import java.util.Properties;


public class MailServiceProperties {
    private volatile static MailService instance;
    private static Properties properties;
    public static void setProperties(Properties properties) {
        synchronized (MailServiceProperties.class) {
            if (instance != null) {
                throw new IllegalStateException("нельзя изменить настройки когда уже было подкл к бд");
            }
            MailServiceProperties.properties = properties;
        }
    }

    public static Properties getProperties() {
        return properties;
    }
}
