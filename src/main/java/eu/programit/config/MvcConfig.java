package eu.programit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
	
    // bean to access database over spring security
    @Bean(name="driverManagerDataSource")
    public DriverManagerDataSource driverManagerDataSource(){
        String host = "jdbc:mysql://"
                + System.getenv().get("OPENSHIFT_MYSQL_DB_HOST")
                + ":"
                + System.getenv().get("OPENSHIFT_MYSQL_DB_PORT")
                + "/serverside";
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://"
                + System.getenv().get("OPENSHIFT_MYSQL_DB_HOST")
                + ":"
                + System.getenv().get("OPENSHIFT_MYSQL_DB_PORT")
                + "/serverside");
        driverManagerDataSource.setUsername("adminKtvbMSA");
        driverManagerDataSource.setPassword("fSm7EuZcznPN");

        return driverManagerDataSource;
    }
}
