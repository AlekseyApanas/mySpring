package groupwork.web.listeners;

import groupwork.service.fabrics.MailServiceProperties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        /*File confDir = new File(System.getenv("catalina_base") + "/conf");*/
        File confDir = new File("C:/IT/programs/apache-tomcat-8.5.85" + "/conf");
        File propMail = new File(confDir + "/mail.properties");
        try {
            Properties properties = new Properties();
            properties.load(new FileReader(propMail));
            MailServiceProperties.setProperties(properties);
        } catch (FileNotFoundException e) {
            throw new IllegalStateException("File with properties not found, create mail.properties in conf", e);
        } catch (IOException e) {
            throw new RuntimeException("Exception in reading mail.properties ", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        deregisterDrivers(getDrivers());
    }

    private Enumeration<Driver> getDrivers(){
        return DriverManager.getDrivers();
    }
    private void deregisterDrivers(Enumeration<Driver> drivers){
        while (drivers.hasMoreElements()){
            deregisterDriver(drivers.nextElement());
        }
    }
    private void deregisterDriver(Driver driver){
        try {
            DriverManager.deregisterDriver(driver);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
